import java.util.*;

public class Main
{
   public static void main(String[] args)
   {
      // you can use this method to test your heap
      // you can put any code you like here

      // here is some sample code that creates
       // a heap...
      Integer[] ary = {2,5, 9, 3};
      List l = Arrays.asList(ary);
      Heap h = new Heap();
      h.insertAll(l);
      System.out.println(h);
      // System.out.println(h.removeTop());
      // System.out.println(h);
      // System.out.println(h.removeTop());
      // System.out.println(h);
      // System.out.println(h.removeTop());
      // System.out.println(h);
      // h.insert(8);
      // System.out.println(h);
      // h.insert(10);
      // System.out.println(h);
      // h.insert(12);
      // h.insert(34);
      // h.insert(2);
      // h.insert(9);
      // System.out.println(h);
      // System.out.println(h.removeTop());
      // System.out.println(h);
      // h.insert(1002);
      // h.insert(876);
      // h.insert(1304);
      // h.insert(2305);
      // System.out.println(h);
   }
}
