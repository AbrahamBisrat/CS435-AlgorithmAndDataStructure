package assignment1A;

import java.util.ArrayList;
import java.util.List;

public class problem5 {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		for(int i = 10; i > 0; i--)
			list.add((int) (Math.random() * 10));
		
		int k = 2;
		System.out.println(naiveSearch(list, k));
		System.out.println(orderedListSearch(problem4.sort(list), k) + " \t" + k);
		
	}

	// Bisection is the best approach here.
	private static boolean orderedListSearch(List<Integer> list, int k) {
		int halfMark = list.size() / 2;
		if(list.get(halfMark) == k)
			return true;
		if(list.size() == 0 || list.size() == 1) return false;
		System.out.println("list: " + list);
		
		return list.get(halfMark) < k 
				? orderedListSearch(list.subList(halfMark, list.size()), k) :
					orderedListSearch(list.subList(0, halfMark), k);
	}

	private static boolean naiveSearch(List<Integer> list, int k) {
		for(Integer each : list)
			if(each == k)
				return true;
		return false;
	}
	
}
