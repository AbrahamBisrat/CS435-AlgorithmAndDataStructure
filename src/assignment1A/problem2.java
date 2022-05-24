package assignment1A;

public class problem2 {
	
	public static void main(String[] args) {
		int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8};
		secondSmallest(testArray);
		
		// test cases;
		int[] testA = {1, 4, 2, 3};
		secondSmallest(testA);
		
		int[] testB = {3, 3, 4, 7};
		secondSmallest(testB);
		
		int[] testC = {9};
//		secondSmallest(testC);
		
		// *** edge case
		int[] testX = {8, 8, 8, 8, 8};
		secondSmallest(testX);
		
	}
	
	private static void secondSmallest(int[] arr) {
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
		System.out.println(secondSmallest == Integer.MAX_VALUE ? "No second Smallest value present" : secondSmallest);
	}
	
}
