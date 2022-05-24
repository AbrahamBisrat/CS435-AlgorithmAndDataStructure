package assignment1A;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class problem4 {
	
	public static void main(String[] args) {
		partA();
		System.out.println("\n\n\n");
		partB();
	}

	private static void partB() {
		List<Integer> list = new LinkedList<>();
		for(int i = 10; i > 0; i--)
			list.add((int) (Math.random() * 10));
		System.out.println(list);
		list = linkedSort(list);
		System.out.println(list);
	}
	
	private static List<Integer> linkedSort(List<Integer> list) {
		return sort(list);
	}

	private static void partA() {
		List<Integer> list = new ArrayList<>();
		for(int i = 10; i > 0; i--)
			list.add((int) (Math.random() * 10));
		System.out.println(list);
		list = sort(list);
		System.out.println(list);
	}
	
	public static List<Integer> sort(List<Integer> list) {
		for(int each : list)
	        for (int i = 0; i < list.size() - 1; i++)
	            if (list.get(i) > list.get(i+1))
	                swap(list, i);
	    return list;
	}

	private static void swap(List<Integer> list, int i) {
		int temp = list.get(i);
		list.set(i, list.get(i+1));
		list.set(i+1, temp);
	}
}
