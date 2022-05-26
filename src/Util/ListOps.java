package Util;

import java.util.ArrayList;
import java.util.List;

public class ListOps {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for(int i = 1; i <= 4; i++)
			list.add(i);
        
//        subsets(list).forEach(System.out::println);
        subsets(list);
	}
	
	public static List<List<Integer>> subsets(List<Integer> nums) {
        List<List<Integer>> list = new ArrayList<>();
        subsetsHelper(list, new ArrayList<>(), nums, 0);
        return list;
    }
	
	// helper so that the above recursion is possible in a clean manner
    private static void subsetsHelper(List<List<Integer>> list , List<Integer> resultList, List<Integer> nums, int start){
        list.add(new ArrayList<>(resultList));
        for(int i = start; i < nums.size(); i++){
        	// add element
            resultList.add(nums.get(i));
            
            
            // Explore
            subsetsHelper(list, resultList, nums, i + 1);
            
            System.out.println(resultList);
            // remove
            resultList.remove(resultList.size() - 1);
        }
    }

}