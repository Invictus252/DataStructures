import java.util.*;

public class Heap implements IHeap
{
  private static Integer[] Heap;


    /**
    * Creates an Integer[] backed object set to 0
    */
    public Heap()
    {
      Heap = new Integer[0];
    }

    /**
    * Checks to see if Heap[nodeIndex] is a leaF
    * @param  nodeIndex  Heap index
    * @return boolean True|False
    */
    private boolean isLeaf(int nodeIndex)
    {
        if (nodeIndex >= (size() / 2) && nodeIndex <= size()) {
            return true;
        }
        return false;
    }

    /**
    * Swaps two named locations in Heap
    * @param  x  Location 1
    * @param  y  Location 2
    */
    private void swap(int x, int y)
    {
        int tmp;
        tmp = Heap[x];
        Heap[x] = Heap[y];
        Heap[y] = tmp;
    }

    /**
    * Moves Heap[nodeIndex] towards top
    * @param  nodeIndex  Heap index
    * @return Kill function if leaf
    */
    public void moveUp(int nodeIndex)
    {
      if (isLeaf(nodeIndex))
        return;
      swap(getRight(nodeIndex, Heap),nodeIndex);
    }

    /**
    * Moves Heap[nodeIndex] away from top
    * @param  nodeIndex  Heap index
    * @return Kill function if leaf
    */
    public void moveDown(int nodeIndex)
    {
      if (isLeaf(nodeIndex))
        return;
      swap(getLeft(nodeIndex,Heap), nodeIndex);
    }

    /**
    * Retrieve parent of Heap[nodeIndex]
    * @return Kill function if leaf
    */
    public int getParent(int nodeIndex)
    {
      return Heap[nodeIndex/2];
    }

    /**
    * Retrieve left child of Heap[nodeIndex]
    * @return Self if null | left child else
    */
    public int getLeft(int nodeIndex, Integer ary[])
    {
        if(size() > 4)
          return ary[(nodeIndex * 2) + 1];
        return ary[1];
    }

    /**
    * Retrieve right child of Heap[nodeIndex]
    * @return Self if null | right child else
    */
    public int getRight(int nodeIndex, Integer ary[])
    {
      if(size() > 4)
        return ary[(nodeIndex * 2) + 2];
      return ary[1];
    }

    /**
    * Modify heap to new size
    * @param h Initialized heap of needed size
    */
    private void copyHeap(Integer[] h)
    {
      for (int i = 0; i < Heap.length; ++i)
      {
        h[i] = Heap[i];
      }
      Heap = h;
    }

    /**
    * default sort of MaxHeap
    */
    private void sort()
    {
      for (int i = 1; i < Heap.length; i++) {
        if(Heap[i-1] > Heap[i]){
          swap(i-1,i);
          sort();
          }
        //System.out.println("in sort() ->  " + toString());
        //System.out.println("in sort()  Heap[i- 1] ->  " + Integer.toString(Heap[i-1]));
        //System.out.println("in sort()  Heap[i] ->  " + Integer.toString(Heap[i]));
      }
    }

    /**
    * Sort based on declaration of needed type
    * @param s Type of sort to be done
    */
    private void sort(String s)
    {
      switch(s) {
        case "MAX":
        case "max":
        case "M":
          for (int i = 1; i < Heap.length; i++) {
            if(Heap[i-1] > Heap[i]){
              swap(i-1,i);
              sort("M");
              }
            //System.out.println("in sort(String s)[MAX] ->  " + toString());
          }
          break;
        case "MIN":
        case "min":
        case "m":
          for (int i = 1; i < Heap.length; i++) {
            if(Heap[i-1] < Heap[i]){
              swap(i-1,i);
              sort("m");
              }
            //System.out.println("in sort(String s)[MIN] ->  " + toString());
          }
          break;
        default:
          System.out.println("Ummm...No");
          break;
      }
    }

    @Override
    public void insert(int item)
    {
      int i, newLen = Heap.length + 1;
      Integer[] newArray = new Integer[newLen];
      Integer[] fitArray = null;
      int size = 0;
      for (i = 0; i < Heap.length; ++i)
      {
        newArray[i] = Heap[i];
      }
      Heap = newArray;
      for (i = 0; i < Heap.length; ++i)
      {
        if(Heap[i] == null){
          Heap[i] = item;
          size = i;
          while(i < Heap.length){
            i++;
          }
        }
      }
      fitArray = new Integer[size + 1];
      for (i = 0; i < fitArray.length; ++i)
      {
        fitArray[i] = Heap[i];
      }
      Heap = fitArray;
      sort();
    }

    @Override
    public void insertAll(List items)
    {
      int newLen = items.size();
      Heap = new Integer[newLen];
      for (int i = 0; i < items.size(); i++) {
        int x =Integer.parseInt(items.get(i).toString());
        Heap[i] =x;
      }
      // Could be user input to declare, Max was presented in class
      sort();
    }

    @Override
    public int size()
    {
      return Heap.length;
    }

    @Override
  	public void clear()
  	{
      Heap = new Integer[0];
  	}

    @Override
    public int removeTop()
    {
      Integer tmp = null;
      for (int i = 0; i < Heap.length-1; i++) {
        tmp = Heap[Heap.length -1- i];
        if(tmp != null){
          Heap[Heap.length-1-i] = null;
          return tmp;
          }
      }
      return tmp;
    }

    @Override
    public String toString()
    {
        return Arrays.toString(Heap);
    }
}
