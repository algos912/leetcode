// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3011/
/*
Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.
Clarification:

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
*/

// TC : O(n)
// SC : O(1)

class Solution {
    public int removeDuplicates(int[] nums) {
        
        // check for invalid inputs
        if(nums == null || nums.length == 0)
            return 0;
        
        //sort input array
        Arrays.sort(nums);
        int k = 0;
        for(int i = 0; i < nums.length; i++) {
            // add first element to output
            if(i == 0){
                nums[k] = nums[i];
                k++;
            // remove duplicates by adding only unique numbers in sorted array
            } else if( nums[i] != nums[i-1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        //return length of new output array of unique elements
        return k;
        
    }
}
