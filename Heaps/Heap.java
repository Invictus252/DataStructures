import java.util.*;

public class Heap implements IHeap
{
  private int[] Heap;
  private int size;

    public Heap()
    {
      this.size = 0;
      Heap = new int[2];
      Heap[0] = 2147483647;
      Heap[1] = 2600;
    }

    private boolean isLeaf(int nodeIndex)
    {
        if (nodeIndex >= (size / 2) && nodeIndex <= size) {
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

    private void moveUp(int nodeIndex)
    {
      if (isLeaf(nodeIndex))
        return;
      swap(getLeft(nodeIndex, Heap),nodeIndex);
      //moveUp(getRight(nodeIndex,Heap));
    }

    private void moveDown(int nodeIndex)
    {
      if (isLeaf(nodeIndex))
        return;
      swap(getRight(nodeIndex,Heap), nodeIndex);
      //moveDown(getLeft(nodeIndex,Heap));
    }

    private int getParent(int nodeIndex)
    {
      return Heap[nodeIndex/2];
    }

    private int getLeft(int nodeIndex, int ary[])
    {
      return ary[nodeIndex * 2];
    }

    private int getRight(int nodeIndex, int ary[])
    {
      return ary[(nodeIndex * 2) + 1];
    }

  //   @Override
  //   public void insert(int item)
  //   {
  //   }
  //
  //   @Override
  //   public void insertAll(List items)
  //   {
  //   }
  //
  //@Override
    public int size()
    {
      return Heap.length;
    }

  //   @Override
  // 	public void clear()
  // 	{
  // 	}
  //
  //   @Override
  //   public int removeTop()
  //   {
  //   }
  //
    @Override
    public String toString()
    {
        String s = "";
        for(int x : Heap){
          s += Integer.toString(x) + "\n";
        }
        return s;
    }
}
