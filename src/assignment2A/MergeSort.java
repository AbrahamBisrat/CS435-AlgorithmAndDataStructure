package assignment2A;

public class MergeSort {
	public static void main(String[] args) {
		int[] x = {1, 4, 5, 8, 17};
		int[] y = {2, 4, 8, 11, 13, 21, 23, 25};
		int[] result = merge(x, y);
		for(int index : result)
			System.out.print(index + " , ");
	}
	
	private static int[] merge(int[] a, int[]b) {
		if(a == null || b == null) throw new IllegalArgumentException("Arrays can't be null");
		int[] resultSet = new int[a.length + b.length];
		
		int aPosition, bPosition, resultSetPosition;
	    aPosition = bPosition = resultSetPosition = 0;

	    while(aPosition < a.length && bPosition < b.length)
	        if (a[aPosition] < b[bPosition])
	            resultSet[resultSetPosition++] = a[aPosition++];
	        else
	            resultSet[resultSetPosition++] = b[bPosition++];

	    while (aPosition < a.length)
	        resultSet[resultSetPosition++] = a[aPosition++];
	    
	    while (bPosition < b.length)
	        resultSet[resultSetPosition++] = b[bPosition++];
	    	
		return resultSet;
	}
}
