// https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1115/

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> numsMap = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(numsMap.containsKey(target - nums[i])){
                return new int[] {i, numsMap.get(target - nums[i])};
            } else {
                numsMap.put(nums[i],i);
            }
        }
        return new int[] {};
    }
}
