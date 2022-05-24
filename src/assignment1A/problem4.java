package assignment1A;

import java.util.ArrayList;
import java.util.List;

public class problem4 {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		for(int i = 4; i > 0; i--)
			list.add((int) (Math.random() * 10));
		
		System.out.println(list);
		
		list = sort(list);
		
		System.out.println(list);
		
	}
	
	private static List<Integer> sort(List<Integer> list) {
		for(int each : list)
	        for (int i = 0; i < list.size() - 1; i++)
	            if (list.get(i) > list.get(i+1))
	                swap(list, i);
	    return list;
	}

	private static void swap(List<Integer> list, int i) {
		System.out.println(list);
		int temp;
		temp = list.get(i);
		list.set(i, list.get(i+1));
		list.set(i+1, temp);
	}
}
