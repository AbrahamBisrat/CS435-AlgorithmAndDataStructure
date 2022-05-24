package assignment1A;

import java.util.ArrayList;
import java.util.List;

public class problem3 {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for(int i = 1; i <= 11; i++)
			list.add(i);
		list.forEach(System.out::println);
		int k = 12;

		System.out.println(sumFound(list, k));
	}
	
	/**
	 * Given an array arr, and int k, find a subset of arr that adds up to k;
	 * 
	 * @param arr
	 * @param sum
	 */
	private static boolean sumFound(List list, int k) {
		// logic
		List<List<Integer>> subsets = Util.ListOps.subsets(list);
		subsets.forEach(System.out::println);
		
		for(List<Integer> subset : subsets) {
			int sum = 0;
			for(int each : subset)
				sum += each;
			if(sum == k) return true;
		}
		return false;
	}
}
