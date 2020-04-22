// https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1147/
// In a given integer array nums, there is always exactly one largest element.
// Find whether the largest element in the array is at least twice as much as every other number in the array.
// If it is, return the index of the largest element, otherwise return -1.

class Solution {
    public int dominantIndex(int[] nums) {
        
        if(nums == null || nums.length == 0)
            return -1;
        
        //find the largest number in the array
        int largestNum = 0;
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > largestNum) {
                largestNum = nums[i];
                index = i;
            }
        }
        
        //check if twice of any other number is greater than the largest number
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == largestNum){
                continue;
            } else if (largestNum < 2 * nums[i]) {
                //if yes, return -1
                return -1;
            }
        }
        // if no, return index of largest number
        return index;
    }
}
