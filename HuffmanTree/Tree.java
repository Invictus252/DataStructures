import java.util.*;
public class Tree implements Comparable<Tree>
{
	private Tree m_left;
	private Tree m_right;
	private Tree m_parent;
	private char m_char;
	private int m_total;

	public Tree(Tree l, Tree r, char ch, int total)
	{
		m_left = l;
		m_right = r;
		m_char = ch;
		m_total = total;
	}

	public Tree getLeft()
	{ return m_left; }

	public Tree getRight()
	{ return m_right; }

	public Tree getParent()
	{ return m_parent; }

	public void setParent(Tree n)
	{ m_parent = n; }

	public int getTotal()
	{ return m_total; }

	public char getChar()
	{ return m_char; }

	public void printTree()
	{
	   _printTree(this);
	}

	public void _printTree(Tree t)
	{
		// add code here to print the tree
		// using a preorder traversal...
    if (t == null) {
      return;
    }
    System.out.println(t.toString());
    if(t.getLeft() != null)
      _printTree(t.getLeft());
    if(t.getRight() != null)
      _printTree(t.getRight());
	}

	@Override
	public String toString()
	{
		return String.format("%s (%2d)", m_char, m_total);
	}

	@Override
	public int compareTo(Tree t2)
	{
		// add code here to ensure that the natural ordering
		// sorts trees in ascending order based on the tree's total,
		// in the case of a tie sort in ascending order
		// based on the tree's letter...
    if(t2.getTotal() < this.m_total)
			return -1;
    if(t2.getTotal() > this.m_total)
			return 1;
		if(t2.getTotal() == this.m_total){
			if(t2.getChar() < this.m_char)
				return -1;
			if(t2.getChar() > this.m_char)
				return 1;
		}
		return 0;
	}
}
