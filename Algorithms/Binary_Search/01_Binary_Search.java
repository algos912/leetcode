// https://leetcode.com/explore/learn/card/binary-search/138/background/1038/
// Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. 
// If target exists, then return its index, otherwise return -1.

class Solution {
    public int search(int[] nums, int target) {
        
        // check for invalid inputs
        if(nums == null || nums.length == 0)
            return -1;
        
        // binary search
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        for(int i = 0; i < nums.length; i++) {
            mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // not found
        return -1;
        
    }
}
