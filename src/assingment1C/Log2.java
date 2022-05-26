package assingment1C;

/**
 * A class to compute the Logarithm of an input to the base 2
 * since this function is not given by the Java math Library, here we are, 
 * Thanks Java.
 * 
 * After a simple re-arrangement of the log equation it would be evident that
 * Log(x) to the base two is quite simply ln(x)/ln(2) - x is input ln2 can be computed
 * 
 * @author Abraham Bisrat
 *
 */

public class Log2 {
	
	public static void main(String[] args) {
		for(int i = 1; i < 10; i++)
			System.out.println(log2(i));
	}
	
	public static double log2(double x) {
		if(x <= 0) throw new IllegalArgumentException("Input can not be zero or negative");
		return Math.log(x)/Math.log(2);
	}
}
