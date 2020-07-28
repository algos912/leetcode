// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/262/
/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/

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
