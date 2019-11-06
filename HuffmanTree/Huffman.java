import java.util.*;
import java.io.*;

public class Huffman
{
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

        public Tree buildTreeFromNodes(List<Tree> nodes)
        {
          Stack<Tree> s = new Stack<Tree>();
          Collections.sort(nodes);
          s.addAll(nodes);
          while (s.size() > 1) {
              Tree left  = s.pop();
              Tree right = s.pop();
              Tree parent = new Tree(left,right,'*', left.getTotal() + right.getTotal());
              s.push(parent);
          }
          return s.pop();
        }

      	public void printTree(Tree root)
      	{
          if (root == null) {
            return;
          }
          if(root.getLeft() != null)
            printTree(root.getLeft());
          if(root.getRight() != null)
            printTree(root.getRight());
          System.out.println(root.toString());
      	}

      	// public String getCode(Tree root, char ch)
      	// {
        //   String out = "";
        //   if(root.getChar() == ch)
        //     return out;
        //   while(root.getChar() != ch){
        //     if (root.getLeft() != null){
        //       out +="0";
        //       getCode(root.getLeft(), ch);
        //     }
        //     if (root.getRight() != null){
        //       out +="1";
        //       getCode(root.getRight(), ch);
        //     }
        //       out = "";
        //   }
      	// }
        //
      	// public String decode(Tree root, String code)
      	// {
        //
      	// }
}
