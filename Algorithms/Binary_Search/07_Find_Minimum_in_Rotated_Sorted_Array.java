// https://leetcode.com/explore/learn/card/binary-search/126/template-ii/949/
/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.
*/

class Solution {
    public int findMin(int[] nums) {
        
        // check for invalid inputs
        if(nums == null || nums.length == 0)
            return -1;
        
        if(nums.length == 1)
            return nums[0];
        
        // binary search
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while(start < end) {
            mid = start + (end - start) / 2;
            
            if (mid > 0 && nums[mid] < nums[mid - 1])
                return nums[mid];
            else if (nums[start] <= nums[mid] && nums[mid] > nums[end])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return nums[start];
        
    }
}
