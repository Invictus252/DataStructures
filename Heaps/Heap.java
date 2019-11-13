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
        //System.out.println(ary[1]);
        return ary[1];
    }

    public int getRight(int nodeIndex, Integer ary[])
    {
      return ary[(nodeIndex * 2) + 2];
    }

    @Override
    public void insert(int item)
    {
      int i, newLen = Heap.length + 1;
      Integer[] newArray = new Integer[newLen];
      for (i = 0; i < Heap.length; ++i)	// copy items
      {
        newArray[i] = Heap[i];
      }
      Heap = newArray;
      Heap[Heap.length -1] = item;
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
      for (int i = 0; i < Heap.length-1; i++) {
        if(Heap[i] < Heap[i+1]){
          swap(i,i+1);
        }
      }
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

  //   @Override
  //   public int removeTop()
  //   {
  //   }
  //
    @Override
    public String toString()
    {
        return Arrays.toString(Heap);
    }
}
