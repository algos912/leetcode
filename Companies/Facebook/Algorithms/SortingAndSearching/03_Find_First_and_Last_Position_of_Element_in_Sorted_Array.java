// Find First and Last Position of Element in Sorted Array
/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums is a non decreasing array.
-10^9 <= target <= 10^9
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] output = {-1, -1};
        
        // check for invalid inputs
        if(nums == null || nums.length == 0)
            return output;
        if(nums.length == 1 && target == nums[0])
            return new int[] {0,0};
        
        // find target with binary search
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while(start < end) {
            mid = start + (end - start)/ 2;
            if (nums[mid] == target) {
                break;
            } else if (nums[mid] < target) {
                start = mid + 1;  
            }
            else {
                end = mid;                
            }
  
        }
        
        //System.out.println(mid);
        if(mid < nums.length && nums[mid] == target) {
            //find start index of target
            int i = mid;
            output[0] = mid;
            while(i >= 0 && nums[i] == target) {
                output[0] = i;
                i--;
            }
            
            //find end index of target
            int j = mid;
            output[1] = mid;
            while(j < nums.length && nums[j] == target) {
                output[1] = j;
                j++;
            }
        }
        
        //System.out.println(start);
        if(start < nums.length && nums[start] == target) {
            //find start index of target
            int i = start;
            output[0] = start;
            while(i >= 0 && nums[i] == target) {
                output[0] = i;
                i--;
            }
            
            //find end index of target
            int j = start;
            output[1] = start;
            while(j < nums.length && nums[j] == target) {
                output[1] = j;
                j++;
            }
        }
        
        //return output array
        return output;
        
    }
}
