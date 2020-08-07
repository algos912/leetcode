// Permutations II
// https://leetcode.com/explore/interview/card/facebook/53/recursion-3/293/
/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/

// https://www.programcreek.com/2013/02/leetcode-permutations-ii-java/
// Based on Permutation, we can add a set to track if an element is duplicate and no need to swap.
// Solution - 1

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(0, nums, result);
        return result;
    }
 
    private void helper(int start, int[] nums, List<List<Integer>> result) {
        if(start==nums.length-1){
            ArrayList<Integer> list = new ArrayList<>();
            for(int num: nums){
                list.add(num);
            }
            result.add(list);
            return;
        }
 
        HashSet<Integer> set = new HashSet<>();
 
        for(int i=start; i<nums.length; i++){
            if(set.contains(nums[i])){
                continue;
            }
            set.add(nums[i]);
 
            swap(nums, i, start);
            helper(start+1, nums, result);
            swap(nums, i, start);
        }
    }
 
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// Java Solution 2
// Use set to maintain uniqueness:
/*

public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
	ArrayList<ArrayList<Integer>> returnList = new ArrayList<ArrayList<Integer>>();
	returnList.add(new ArrayList<Integer>());
 
	for (int i = 0; i < num.length; i++) {
		Set<ArrayList<Integer>> currentSet = new HashSet<ArrayList<Integer>>();
		for (List<Integer> l : returnList) {
			for (int j = 0; j < l.size() + 1; j++) {
				l.add(j, num[i]);
				ArrayList<Integer> T = new ArrayList<Integer>(l);
				l.remove(j);
				currentSet.add(T);
			}
		}
		returnList = new ArrayList<ArrayList<Integer>>(currentSet);
	}
 
	return returnList;
}

*/
