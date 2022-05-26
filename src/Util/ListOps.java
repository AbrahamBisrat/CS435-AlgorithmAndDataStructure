package Util;

import java.util.ArrayList;
import java.util.List;

public class ListOps {
	
//	public static void main(String[] args) {
//		int[] nums= {1, 2, 1};
//		List<Integer> list = new ArrayList<>();
//		for(int i = 1; i <= 3; i++)
//			list.add(i);
//        List<List<Integer>> subsets = subsets(list);
//        
//        for (List<Integer> subset: subsets) {
//            System.out.println(subset);
//        }
//        
//	}
	
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
           // remove
            resultList.remove(resultList.size() - 1);
        }
    }

}
