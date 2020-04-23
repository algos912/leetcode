// https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1173/
// Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
// Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

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
