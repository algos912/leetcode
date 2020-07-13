// https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2944/
// https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2868/
/*
Given an array of integers nums, sort the array in ascending order.

Example 1:
Input: nums = [5,2,3,1]
Output: [1,2,3,5]

Example 2:
Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5] 

Constraints:
1 <= nums.length <= 50000
-50000 <= nums[i] <= 50000
*/

class Solution {
    public int[] sortArray(int[] nums) {
        
        // check for invalid inputs
        if(nums.length <= 1)
            return nums;
        
        // merge sort
        // divide input set of values into two
        int pivot = nums.length / 2;
        // recursion
        int[] left = sortArray(Arrays.copyOfRange(nums, 0, pivot));
        int[] right = sortArray(Arrays.copyOfRange(nums, pivot, nums.length));
        return merge(left, right);
    }
    
    public int[] merge(int[] left, int[] right) {
      int[] ret = new int[left.length + right.length];
      int left_cursor = 0, right_cursor = 0, ret_cursor = 0;

      while (left_cursor < left.length && 
             right_cursor < right.length) {
        if (left[left_cursor] < right[right_cursor]) {
          ret[ret_cursor++] = left[left_cursor++];
        } else {
          ret[ret_cursor++] = right[right_cursor++];
        }
      }
      // append what is remain the above lists
      while (left_cursor < left.length) {
        ret[ret_cursor++] = left[left_cursor++];
      }
      while (right_cursor < right.length) {
        ret[ret_cursor++] = right[right_cursor++];
      }  
      return ret;
    }
    
    
}

