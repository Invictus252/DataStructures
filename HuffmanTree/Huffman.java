import java.util.*;
import java.io.*;

public class Huffman
{
        /**
        * Takes a comma delimited file and converts to an ArrayList
        * Throws error if no/incorrect file
        * @param  file  a file named in  Main.java
        * @param  nodes initialized List of type <Tree>
        */
        public void populateNodesFromFile(String file, List<Tree> nodes) throws FileNotFoundException
        {
          try(BufferedReader in = new BufferedReader(new FileReader(file))) {
              String str;
              while ((str = in.readLine()) != null) {
                  System.out.println(str);
                  String[] tokens = str.split(",");
                  Tree t = new Tree(null,null,tokens[0].charAt(0),Integer.parseInt(tokens[1]));
                  nodes.add(t);
              }
          }
          catch (IOException e) {
              System.out.println("File Read Error");
          }
        }

        /**
        * Takes ArrayList of type <Tree> and builds Binary Tree
        * @param  nodes initialized and loaded List of type <Tree>
        * @return Assembled Tree from a root of the remaining Stack<Tree> element
        */
        public Tree buildTreeFromNodes(List<Tree> nodes)
        {
          Stack<Tree> s = new Stack<Tree>();
          s.addAll(nodes);
          while (s.size() > 1) {
              Tree left  = s.pop();
              Tree right = s.pop();
              Tree parent = new Tree(left,right,'*', left.getTotal() + right.getTotal());
              s.push(parent);
          }
          return s.pop();
        }

        /**
        * Prints trees contents using Post-Order Traversal
        * @param  root  Established Tree from List<Tree> nodes
        */
      	public void printTree(Tree root)
      	{
          if(root.getLeft() != null)
            printTree(root.getLeft());
          if(root.getRight() != null)
            printTree(root.getRight());
          System.out.println(root.toString());
      	}

        /**
        * Huffman code from cited char
        * @param  root  Established Tree from List<Tree> nodes
        * @param  ch char to be searched for
        * @return Stripped string in Huffman format ie numeric
        */
      	public String getCode(Tree root, char ch)
      	{;
          String tmp = String.valueOf(ch);
          String out = "";
          Map<String, String> codes = new HashMap<>();
          Stack<String> S = new Stack<>();
          codes = _makeCodes(root,S,codes);
          for (Map.Entry<String,String> entry : codes.entrySet()){
            if(entry.getKey().equals(tmp)){
              out = entry.getValue();
            }
          }
          if(out.equals(""))
            return "Not Found";
          else
            return out;
      	}

        /**
        * Helper function to create a HashMap of established leaves
        * within List<Tree> nodes
        * @param  root  Established Tree from List<Tree> nodes
        * @param  S used to set codes during traversal
        * @param codes HashMap of cataloged leaves
        * @return completed HashMap for getCode()
        */
        public Map<String, String> _makeCodes(Tree root, Stack<String> S, Map<String, String> codes)
      	{
          if(root == null)
            return  codes;
          if(root.getLeft() != null && root.getRight() != null)
            S.push("0");
          codes = _makeCodes(root.getLeft(),S,codes);
          if(root.getLeft() == null && root.getRight() == null){
            char c = root.getChar();
            String tmp = String.valueOf(c);
            codes.put(tmp,Arrays.toString(S.toArray()).replace("[", "").replace("]", "").replace(",", ""));
            S.pop();
          }
          if(root.getLeft() != null && root.getRight() != null)
            S.push("1");
          codes = _makeCodes(root.getRight(),S,codes);
          if(root.getLeft() != null && root.getRight() != null && !S.isEmpty())
            S.pop();
          return codes;
      	}

        /**
        * Huffman decode from cited String
        * @param  root  Established Tree from List<Tree> nodes
        * @param  code Code to be analyzed
        * @return Decoded message
        */
      	public String decode(Tree root, String code)
      	{
          if (root == null) {
                  return code;
              }
          char[] arr = code.toCharArray();
          int i = 0;
          String out = "";
          while (i < arr.length) {
              Tree t = root;
              while (t != null) {
                  if (t.getLeft() == null && t.getRight() == null) {
                      out += t.getChar();
                      break;
                  } else {
                      char c = arr[i];
                      if (c == '0') {
                          t = t.getLeft();
                      } else {
                          t = t.getRight();
                      }
                      i++;
                  }
              }
          }
          return out;
      	}
}
