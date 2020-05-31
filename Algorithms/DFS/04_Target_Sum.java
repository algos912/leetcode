// https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1389/

// You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
// Find out how many ways to assign symbols to make sum of integers equal to target S.

class Solution {
    int output = 0;
    public int findTargetSumWays(int[] nums, int S) {
        // check for invalid inputs
        if(nums == null || nums.length == 0)
            return output;
        
        helper(nums, S, 0, 0);
        return output;
    }
    
    public void helper(int[] nums, int target, int pos, long eval) {
        if (pos == nums.length) {
            if (target == eval) 
                output++;
            return;
        }
        
        helper(nums, target, pos + 1, eval + nums[pos]);
        helper(nums, target, pos + 1, eval - nums[pos]);
        
    }
}
