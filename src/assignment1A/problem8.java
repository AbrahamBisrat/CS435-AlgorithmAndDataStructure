package assignment1A;

public class problem8 {
	public static void main(String[] args) {
		System.out.println(smallestCommon(12, 18));
	}
	private static int smallestCommon(int x, int y) {
		if(x == 0 || y == 0) return 0; 
		int a = Math.abs(x);
	    int b = Math.abs(y);
	    int higherNum = Math.max(a, b);
	    int lowerNum = Math.min(a, b);
	    int lcm = higherNum;
	    while (lcm % lowerNum != 0) {
	        lcm += higherNum;
	    }
	    return lcm;
	}
}
