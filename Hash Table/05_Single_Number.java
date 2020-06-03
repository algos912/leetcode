// https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1176/

// Given a non-empty array of integers, every element appears twice except for one. Find that single one.
// Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

class Solution {
    public int singleNumber(int[] nums) {
        
        // check for invalid inputs
        if(nums == null || nums.length == 0)
            return -1;
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i=i+2) {
            if(i+1 == nums.length)
                return nums[i];
            else if(nums[i] != nums[i+1])
                return nums[i];
        }
        return -1;
        
    }
}
