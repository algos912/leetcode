// https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1299/
// https://leetcode.com/problems/minimum-size-subarray-sum/
// Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        // check for invalid inputs
        if(nums == null || nums.length == 0)
            return 0;
        
        int len = nums.length;
        int minSubArrayLength = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for(int i = 0; i < len; i++) {
            sum += nums[i];
            while(sum >= s) {
                minSubArrayLength = Math.min(minSubArrayLength, i+1-left);
                sum -= nums[left++];
            }
        }
        
        if(minSubArrayLength != Integer.MAX_VALUE)
            return minSubArrayLength;
        else
            return 0;
    }
}
