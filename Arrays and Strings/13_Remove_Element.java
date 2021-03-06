// https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1151/
// Given an array nums and a value val, remove all instances of that value in-place and return the new length.
// Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
// The order of elements can be changed. It doesn't matter what you leave beyond the new length.

class Solution {
    public int removeElement(int[] nums, int val) {
        // check for invalid inputs
        if(nums == null || nums.length == 0)
            return 0;
        
        int k = 0;
        for(int i = 0; i < nums.length; i++) {
            // remove val
            if(nums[i] != val){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
        
    }
}
