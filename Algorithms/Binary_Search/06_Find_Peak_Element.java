// https://leetcode.com/explore/learn/card/binary-search/126/template-ii/948/
/*
A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
*/

class Solution {
    public int findPeakElement(int[] nums) {
        
        // check for invalid inputs
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        // Linear search : TC O(n)
        int max = nums[0];
        int index = 0;
        int prev = 0;
        int curr = 0;
        int next = 0;
        for(int i = 1; i < nums.length - 1; i++) {
            prev = nums[i-1];
            curr = nums[i];
            next = nums[i+1];
            
            if(curr > prev && curr > next && curr > max) {
                max = curr;
                index = i;
            }
        }
        
        if(nums[nums.length-1] > max)
            return nums.length - 1;
        
        return index;
        
    }
}
