package lab5;

import java.util.Collection;
import java.util.LinkedList;
import java.util.NoSuchElementException;
/**
 * 
 * Improved stack implementation, push, pop, peek, isEmpty and also min
 * so that the worst case running time for any operation is O(1).
 * 
 * 
 * @author 	Er. Abraham Birat
 * @param 	<T>
 * 
 */
public class MinStack <T extends Comparable<T>> {
	
	private LinkedList<T> stack = new LinkedList<>();
	
	/**
	 *  Constructs Empty list
	 */
	public MinStack() {}
	
	/**
	 * Constructs a list containing the elements of the specified collection,
	 * In the order reverse order they are presented.
	 * 
	 * @param s
	 */
	@SuppressWarnings("unchecked")
	public MinStack(Collection<? extends Comparable<T>> s) {
		this();
		for(Object each : s)
			this.push((T) each);
	}

	public static void main(String[] args) {
		MinStack<String> minStack = new MinStack<>();
		System.out.println(minStack);
		minStack.push("3");
		minStack.push("2");
		minStack.push("1");
		System.out.println(minStack);
		System.out.println("min val : " + minStack.min());
		
		System.out.println(minStack.pop());
		System.out.println(minStack.pop());
		System.out.println("min val : " + minStack.min());		
		System.out.println(minStack.pop());
		System.out.println(minStack);
		
		MinStack<String> minStackTheSecond = new MinStack<>() {{
			push("a");
			push("b");
			push("c");
			push("d");
		}};
		System.out.println("\n" + minStackTheSecond);
		
	}
	// check for edge cases;
	
	
	/**
	 * Implementation using checks on push fail when that -min- object is no longer in stack.
	 * thus requiring the re-assessment of the whole stack. 
	 *  
	 * @return minVal
	 * @throws RuntimeException
	 */
	public T min() {
		return stack.stream().sorted().findFirst()
				.orElseThrow(() -> new RuntimeException("No min value"));
	}
	
	public T peek() {
		if(isEmpty()) throw new NoSuchElementException("No elements present");
		return stack.getFirst();
	}
	
	public Object pop() {
		if(isEmpty()) throw new RuntimeException("Stack is empty");
		Object o = stack.getFirst();
		stack.removeFirst();
		return o;
	}
	
	public void push(T t) { 
		stack.addFirst(t);
	}
	
	public boolean isEmpty() { 
		return stack.isEmpty();
	}
	
	public String toString() {
		if(isEmpty()) return "Stack is Empty!";
		String toString = "";
		for(Object o : stack)
			toString += o + "\n";
		return toString;
	}
}
