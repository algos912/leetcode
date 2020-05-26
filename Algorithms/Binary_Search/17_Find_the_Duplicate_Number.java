// https://leetcode.com/explore/learn/card/binary-search/146/more-practices-ii/1039/
// Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

class Solution {
    public int findDuplicate(int[] nums) {
        
        // check for invalid inputs
        if(nums == null || nums.length == 0)
            return -1;
        
        // Linear Search 
        // TC : O(n2)
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
                // find duplicate
                if(nums[i] == nums[j] && i != j)
                    return nums[i];
            }
        }
        
        // no duplicate
        return -1;
        
    }
}
