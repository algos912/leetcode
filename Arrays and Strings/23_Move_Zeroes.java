// https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1174/
// Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
// Do it in-place

class Solution {
    public void moveZeroes(int[] nums) {
        
        // check for invalid inputs
        if( nums == null || nums.length == 0) {
            return;
        }
        
        // use two pointer technique
        int k = 0;
        for(int i = 0; i < nums.length; i++) {
            // add only non-zero elements
           if (nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            }
        }
        
        //append zeroes to the end
        while (k < nums.length) {
            nums[k] = 0;
            k++;
        }
        
    }
}
