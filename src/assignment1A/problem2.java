package assignment1A;

public class problem2 {
	
	public static void main(String[] args) {
		int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8};
		System.out.println(secondSmallest(testArray));
		
		// test cases;
		int[] testA = {1, 4, 2, 3};
		System.out.println(secondSmallest(testA));
		
		int[] testB = {3, 3, 4, 7};
		System.out.println(secondSmallest(testB));
		
		int[] testC = {9};
		System.out.println(secondSmallest(testC));
		
		// *** edge case
		int[] testX = {8, 8, 8, 8, 8};
		System.out.println(secondSmallest(testX));
		
	}
	
	private static int secondSmallest(int[] arr) {
		if(arr == null || arr.length < 2 ) 
			throw new IllegalArgumentException("Input Array too small");
		int smallest = Integer.MAX_VALUE;
		int secondSmallest = Integer.MAX_VALUE;
		
		for(int each : arr) {
			if(each < smallest) {
				secondSmallest = smallest;
				smallest = each;
			} else if(each < secondSmallest && each > smallest)
				secondSmallest = each;
		}
		if(secondSmallest == Integer.MAX_VALUE) throw new RuntimeException("No second smallest value present");
		return secondSmallest;
	}
	
}
