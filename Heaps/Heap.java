import java.util.*;

public class Heap implements IHeap
{
  private static Integer[] Heap;

    public Heap()
    {
      Heap = new Integer[0];
    }

    private boolean isLeaf(int nodeIndex)
    {
        if (nodeIndex >= (size() / 2) && nodeIndex <= size()) {
            return true;
        }
        return false;
    }

    private void swap(int x, int y)
    {
        int tmp;
        tmp = Heap[x];
        Heap[x] = Heap[y];
        Heap[y] = tmp;
    }

    public void moveUp(int nodeIndex)
    {
      if (isLeaf(nodeIndex))
        return;
      swap(getLeft(nodeIndex, Heap),nodeIndex);
    }

    public void moveDown(int nodeIndex)
    {
      if (isLeaf(nodeIndex))
        return;
      swap(getRight(nodeIndex,Heap), nodeIndex);
    }

    public int getParent(int nodeIndex)
    {
      return Heap[nodeIndex/2];
    }

    public int getLeft(int nodeIndex, Integer ary[])
    {
        if(size() > 4)
          return ary[(nodeIndex * 2) + 1];
        return ary[1];
    }

    public int getRight(int nodeIndex, Integer ary[])
    {
      return ary[(nodeIndex * 2) + 2];
    }

    private void sort()
    {
      for (int i = 1; i < Heap.length; i++) {
        if(Heap[i-1] > Heap[i]){
          swap(i-1,i);
          sort();
          }
        System.out.println("in sort() ->  " + toString());
        System.out.println("in sort()  Heap[i- 1] ->  " + Integer.toString(Heap[i-1]));
        System.out.println("in sort()  Heap[i] ->  " + Integer.toString(Heap[i]));
      }
    }

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
            System.out.println("in sort(String s)[MAX] ->  " + toString());
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
            System.out.println("in sort(String s)[MIN] ->  " + toString());
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
      for (i = 0; i < Heap.length; ++i)	// copy items
      {
        newArray[i] = Heap[i];
        if(newArray[i] == null){
          newArray[i] = item;
          while(i < Heap.length){
            newArray[i+1] = null;
            i++;
          }
        }
      }
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
