// https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1144/
// Given an array of integers nums, write a method that returns the "pivot" index of this array.
// We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
// If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.

class Solution {
    public int pivotIndex(int[] nums) {
        //check for invalid input    
        if(nums == null || nums.length <= 2)
            return -1;
        
        //find sum of numbers at each index
        int len = nums.length;
        int[] sumsAtEachIndex = new int[len];
        for(int i = 0; i < len; i++) {
            if(i == 0)
                sumsAtEachIndex[i] = nums[i];
            else
                sumsAtEachIndex[i] = sumsAtEachIndex[i-1] + nums[i];
        }
        
        //sum to the left = sum at index i - nums[i]
        //sum to the right = sum at index i - sumLeft - nums[i]
        // at pivot index, sum to the left = sum to the right
        
        int sumLeft = 0;
        int sumRight = 0;
        for(int i = 0; i < len; i++) {
            sumLeft = sumsAtEachIndex[i] - nums[i];
            sumRight = sumsAtEachIndex[len-1] - sumLeft - nums[i];
            if(sumLeft == sumRight)
                // return pivot index
                return i;
        }
        return -1;
        
    }
}
