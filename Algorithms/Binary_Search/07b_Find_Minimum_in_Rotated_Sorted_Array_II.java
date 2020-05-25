// https://leetcode.com/explore/learn/card/binary-search/144/more-practices/1031/
/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.
*/

class Solution {
    public int findMin(int[] nums) {
        
        // check invalid inputs
        if(nums == null || nums.length == 0)
            return -1;
        
        //edge case
        if(nums.length == 1)
            return nums[0];
        
        // binary search
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            // handle duplicates
            while(nums[start] == nums[end] && start != end) {
                start++;
            }
            
            if(nums[start] <= nums[end])
                return nums[start];
            
            mid = start + (end - start) / 2;
            if(nums[mid] >= nums[start])
                start = mid + 1;
            else
                end = mid;
        }
        return -1;
        
    }
}
