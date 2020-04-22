// https://leetcode.com/problems/two-sum/
// Given an array of integers, return indices of the two numbers such that they add up to a specific target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // check for invalid inputs
        if(nums == null || nums.length == 0)
            return new int[] {};
        
        //Brute force TC : O(n2)
        /*
        for(int i = 0; i < nums.length-1; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target)
                    return new int[] {i,j};
            }
        }
        */
        
        //Using HashMap, TC : O(n)
        HashMap<Integer, Integer> twoMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(twoMap.containsKey(target - nums[i]))
                return new int[] {twoMap.get(target - nums[i]), i};
            else
                twoMap.put(nums[i], i);
        }
        return new int[]{};
        
    }
}
