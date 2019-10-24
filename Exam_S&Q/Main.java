import java.util.*;

public class Main
{
    public static void main(String args[])
    {
      IStack<Integer> MINstack = new MinStack<Integer>();
      System.out.println(MINstack);
      MINstack.push(10);
      MINstack.push(8);
      MINstack.push(6);
      System.out.println(MINstack);
      // System.out.println(MinStack.m_actual);
    }



}
