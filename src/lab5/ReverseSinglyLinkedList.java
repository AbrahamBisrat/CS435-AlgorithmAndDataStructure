package lab5;

import java.util.List;

public class ReverseSinglyLinkedList {
	public static void main(String[] args) {
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");
		
		System.out.println(list);
		System.out.println(reverse(list));
	}
	private static SinglyLinkedList<?> reverse(SinglyLinkedList<?> list) {
		SinglyLinkedList<String> temp = new SinglyLinkedList<>();
		for(int i = list.size(); i >= 0; i--)
			temp.add((String) list.get(i));
		return temp;
	}
}
