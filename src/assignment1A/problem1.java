package assignment1A;

import java.util.HashMap;

/**
 * 
 * @author Abraham Bisrat
 * Algorithms class of 2022 - Maharishi International univerisity
 *
 */

public class problem1 {
	
	public static void main(String[] args) {
		problemOne();
	}
	
	/**
	 * Given an array of distinct integers and an integer Z, determine whether the array
	 * contains two distinct numbers X and Y such that x + y = z
	 */
	private static void problemOne() {
		int[] testArray = {1, 2, 3, 4, 5, 6, 6, 7, 8, 9};
		int z = 15;
		System.out.println(naiveSumFound(testArray, z));
		System.out.println(hashSumFound(testArray, z));
		
		// Test examples
		int[] testA = {1, 4, 2, 3};
		z = 5;
		System.out.println(hashSumFound(testA, z));
		
		int[] testB = {3, 3, 4, 7};
		z = 6;
		System.out.println(hashSumFound(testB, z));
		
		int[] testC = {1};
		z = 2;
		System.out.println(hashSumFound(testC, z));
		
	}
	
	// O(n2)
	private static boolean naiveSumFound(int[] arr, int z) {
		for(int i = 0; i < arr.length; i++)
			for(int j = 0; j < arr.length; j++) 
				if(arr[i] + arr[j] == z && arr[i] != arr[j]) 
					return true;
		return false;
	}
	
	// O(n)
	private static boolean hashSumFound(int[] arr, int z) {
		HashMap<Integer, Integer> hashArray = new HashMap<>();
		for(int each : arr) {
			hashArray.put(each, each);
			if(hashArray.containsValue(z - each) && each != z - each)
				return true;
		}
		return false;
	}

}