// Search in Rotated Sorted Array
/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
*/

class Solution {
    public int search(int[] nums, int target) {
        
        //check for invalid inputs
        if(nums == null || nums.length == 0)
            return -1;
        
        //binary search
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;
        while(lo < hi) {
            mid = lo + (hi - lo) / 2;
            if(nums[mid] == target)
                return mid;
            
            if(nums[lo] <= nums[mid]) {
                if(nums[lo] <= target && target < nums[mid])
                    hi = mid - 1;
                else
                    lo = mid + 1;
                
            } else {
                if(nums[mid] < target && target <= nums[hi])
                    lo = mid + 1;
                else
                    hi = mid - 1;  
            }
        }
        //end condition
        return (nums[hi] == target) ? hi : -1;
        
    }
}
