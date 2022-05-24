package assignment1A;

import java.util.ArrayList;
import java.util.List;

public class problem6 {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for(int i = 10; i >= 0; i--)
			list.add((int) (Math.random() * 100));
		list.forEach(System.out::println);
		List<List<Integer>> subsets = Util.ListOps.subsets(list);
		
		subsets.forEach(System.out::println);
	}

}
