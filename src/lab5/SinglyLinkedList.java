package lab5;

import java.util.NoSuchElementException;

public class SinglyLinkedList <T> {
	protected class Node <E>{
		E data;
		Node<E> next;
		
		public Node() {}
		
		public Node(E data) {
			this.data = data;
		}
	}
	
	Node<T> head;
	private int size;
	
	public SinglyLinkedList() {
		size = 0;
	}
	
	public void add(T t) {
		Node<T> newHead = new Node<T>(t);
		if(head == null) {
			head = newHead;
			size++;
			return;
		}
		newHead.next = head;
		head = newHead;
		size++;
	}
	public T get(int index) {
		Node<T> temp = head;
		int i = 0;
		while(temp.next != null) {
			if(i == index) {
				return temp.data;
			}
			temp = temp.next;
			i++;
		}
		throw new NoSuchElementException("Index not found");
	}
	public void removeByValue(T t) {
		Node<T> temp = head;
		while(temp.next != null) {
			if(temp.next.data.equals(t)) {
				temp.next = temp.next.next;
				size--;
			}
			temp = temp.next;
		}
	}
	public void removeByIndex(int index) {
		Node<T> temp = head;
		int i = 0;
		
		while(temp.next != null) {
			if(i == index) {
				temp.next = temp.next.next;
				size--;
				return;
			}
			temp = temp.next;
			i++;
		}
	}
	public void insertByIndex(T t, int index) {
		if(index >= size) {
			System.out.println("Index is over the size of the list");
			return;
		}
		Node<T> temp = head;
		Node<T> insertNode = new Node<>(t);
		
		int i = 0;
		while(temp.next != null) {
			if(i == index) {
				insertNode.next = temp;
				temp.next = insertNode;
				size++;
				return;
			}
			temp = temp.next;
			i++;
		}
	}
	public void insertStack(T t, int index) {
		Node<T> newInput = new Node<>(t);
		if(index < 0 || index > size)
	        throw new IllegalArgumentException();
	    Node<T> temp = head; //Save original head
	    for(int i=0;i<index-1;i++)
	        temp = temp.next;
	    newInput = temp.next;
	    temp.next = newInput;
	    size++;
	}
	public void replace(T t, int index) {
		if(index >= size) return;
		Node<T> temp = head;
		int i = 0;
		
		while(temp.next != null	) {
			if(i == index) {
				temp.data = t;
			}
			temp = temp.next;
			i++;
		}
	}
	public int size() {
		return size;
	}
	
	@Override public String toString() {
		String s = "";
		Node<T> temp = head;
		
		while(temp != null) {
			s += temp.data + ", ";
			temp = temp.next;
		}
		return s;
	}
}
