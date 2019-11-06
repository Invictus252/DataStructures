import java.util.*;
import java.io.*;


public class PlayGround
{
   	public static void main(String[] args) throws FileNotFoundException
	{
    try(BufferedReader in = new BufferedReader(new FileReader("tree.txt"))) {
        List<Tree> nodes = new ArrayList<Tree>();
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
}
