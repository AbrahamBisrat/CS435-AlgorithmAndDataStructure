package assignment1A;

import java.util.ArrayList;
import java.util.List;

public class problem3 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 11; i++)
			list.add(i);
		int k = 12;

		System.out.println(sumFound(list, k));
		
		int[] testA = {1, 3, 9, 4, 8, 5}; 
		k = 21;
		System.out.println(sumFound(arrayToList(testA), k));
		
		k = 22;
		System.out.println(sumFound(arrayToList(testA), k));
		
		k = 31;
		System.out.println(sumFound(arrayToList(testA), k));
		
		k = 0;
		System.out.println(sumFound(arrayToList(testA), k));
		
	}
	
	public static List<Integer> arrayToList(int[] arr) {
		List<Integer> list = new ArrayList<>();
		for(int each : arr) 
			list.add(each);
		return list;
	}
	
	/**
	 * Given an array arr, and int k, find a subset of arr that adds up to k;
	 * 
	 * @param arr
	 * @param sum
	 */
	private static boolean sumFound(List<Integer> list, int k) {
		List<List<Integer>> subsets = Util.ListOps.subsets(list);
//		subsets.forEach(System.out::println);

		for (List<Integer> subset : subsets) {
			int sum = 0;
			for (int each : subset)
				sum += each;
			if (sum == k)
				return true;
		}
		return false;
	}
}
