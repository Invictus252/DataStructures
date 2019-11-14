import java.util.*;

public class Main
{
   public static void main(String[] args)
   {
      // you can use this method to test your heap
      // you can put any code you like here

      // here is some sample code that creates
       // a heap...
      //Integer[] ary = {2,5, 9, 3};
      Integer[] ary = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
      List l = Arrays.asList(ary);
      Heap h = new Heap();
      h.insertAll(l);
      System.out.println(h);
      System.out.println(h.removeTop());
      System.out.println(h);
      System.out.println(h.removeTop());
      System.out.println(h);
      System.out.println(h.removeTop());
      System.out.println(h);
      h.insert(8);
      System.out.println(h);
   }
}
