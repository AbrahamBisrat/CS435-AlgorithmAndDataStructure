package assignment1A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class problem7 {
	public static void main(String[] args) {
		System.out.println(generateFib(20));
	}
	private static List<Integer> generateFib(int x) {
		if(x < 0) throw new IllegalArgumentException("Index starts from 1");
		if(x == 0) return Arrays.asList(0);
		if(x == 1) return Arrays.asList(1);
		int firstNumber = 0;
		int secondNumber = 1;
		List<Integer> resultSet = new ArrayList<>();
		resultSet.add(firstNumber);
		resultSet.add(secondNumber);
		for(int i = 1; i < x; i++) {
			int temp = secondNumber;
			secondNumber += firstNumber;
			firstNumber = temp;
			resultSet.add(secondNumber);
		}
		return resultSet;
	}
}
