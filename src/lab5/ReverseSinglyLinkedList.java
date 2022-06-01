package lab5;

import java.util.List;

public class ReverseSinglyLinkedList {
	public static void main(String[] args) {
		SinglyLinkedListImp list = new SinglyLinkedListImp();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");
		
		System.out.println(list);
		System.out.println(reverse(list));
		
	}
	private static SinglyLinkedListImp reverse(SinglyLinkedListImp list) {
		SinglyLinkedListImp temp = new SinglyLinkedListImp();
		for(int i = list.size() - 1; i >= 0; i--)
			temp.add(list.get(list.size() - i - 1));
		return temp;
	}
}
