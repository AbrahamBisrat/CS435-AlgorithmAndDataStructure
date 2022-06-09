package Util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class ListOps {
	public static void p(Object line) { System.out.println(line); }
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for(int i = 1; i <= 3; i++)
			list.add(i);
        
		benchmark(placeHolder -> subsets(list));
        
        // Another implementation
        benchmark(placeHolder -> p(powerSet(list)));
	}
	
	private static void benchmark(Consumer<String> consumer) {
		long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long startTime = System.currentTimeMillis();
		
		consumer.accept(null);
		
		long endTime = System.currentTimeMillis();
		long after = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        p("Execution time : " + (endTime - startTime) + "ms");
        p("Memory Consumed : " + (after - before));
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
            
            p(resultList);
            
            // remove.
            resultList.remove(resultList.size() - 1);
            
        }
    }
    
    /*
     * Another approach inspired the book "Cracking the coding interview"
     * 
     * for the list [a,b,c] the power set and combinations can easily be calculated as
     * the following, first let's see the case of the power set
	 *
     *  	lets assume x = {[a]u[a]*[b]u[b]} for simplicity
     *  	* means the element to the right is put in all possible location of the left operand
     *  	example [a]u[c] -> [ca], [ac]
     *  
     *  PowerSet[a,b,c] = {[x]u[x]*[c]u[c]}
     * 	
     *  and in a similar fashion the combinations becomes
     *  
     *  Combinations[a,b,c] -> In this case we do not care about the left over computations we saved in 
     *  the previous power-set example. we only care about the set containing all the elements. 
     *  	Comb[a,b,c] = {[[a]*[b]]*[c]}
     *  
     *  two helper methods : merge(list1, list2) and addToAllLocations(list, element)
     */
    // later convert to Generic implementation
    public static List<List<Integer>> powerSet(List<Integer> list) {
    	List<List<Integer>> pSet = new ArrayList<>();
    	pSet.add(new ArrayList<>());
    	for(Integer each : list)
    		pSet = merge(pSet, addToAllLocations(pSet, each));
    	return pSet.stream().sorted(Comparator.comparing(List::size)).toList();
    }
    private static List<List<Integer>> merge(List<List<Integer>> listA, List<List<Integer>> listB) {
    	List<List<Integer>> newList = listB;
    	newList.addAll(listA);
    	return newList;
    }
    private static List<List<Integer>> addToAllLocations(List<List<Integer>> list, int element) {
    	List<List<Integer>> resultSet = new ArrayList<>();
    	for(List<Integer> each : list)
	    	for(int i = 0; i <= each.size(); i++)
	    		resultSet.add(listInsertElementHelper(each, element, i));
    	return resultSet;
    }
    private static List<Integer> listInsertElementHelper(List<Integer> list, int element, int index) {
    	List<Integer> newList = new ArrayList<>(list);
    	newList.add(index, element);
    	return newList;
    }
}







