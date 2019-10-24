import java.util.*;
/**
 * <p>Concreted class for a Stack that is backed by a
 * ArrayList structure.</p>
 * <p>Created for CSCI361 at MCLA</p>
 *
 * @author js5986@mcla.edu
 *
 * @param <T> the data type of the elements contained in the stack.
 */
public class StackArray<T> implements IStack<T>
{
	private ArrayList<T> stack ;

			public StackArray() {
	        stack = new ArrayList<T>();
	    }

	    @Override
	    public void push(T item) {
				stack.add(item);
	    }

	    @Override
	    public T pop() {
				if(stack.size()==0)
            throw new IllegalStateException("Stack is empty");
				Collections.reverse(stack);
				T tmp = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
				return tmp;
	    }

			@Override
	    public T top() {
				if (stack.size() == 0)
					throw new IllegalStateException("Stack is empty!");
	      return stack.get(stack.size()-1);
	    }

	    @Override
	    public int getSize() {
	        return stack.size();
	    }

	    @Override
	    public boolean isEmpty() {
	        return getSize() == 0;
	    }

	    /**
	     * returns String view of Stack, fist element
	     * is the top of stack
	     */
	    @Override
	    public String toString() {
				StringBuffer sb = new StringBuffer("top");
				if(!isEmpty()){
					Collections.sort(stack, Collections.reverseOrder());
					for(T item : stack){
						sb.append("->");
						sb.append(item);
					}
				}else{
					sb.append("->");
				}
	      return sb.toString();
	    }
	}
