// https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1299/
// Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        // check for invalid inputs
        if(nums == null || nums.length == 0)
            return 0;
        
        int k, sum = 0;
        int minK = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            sum = 0;
            k = 0;
            // find k, the min array-length for which sum <= s
            while(sum <= s) {
                sum += nums[i];
                k++;
            }
            
            // save minimum value of k
            if(sum >= s) {
                minK = Math.min(k, minK);
            }
        }
        return minK;
    }
}
