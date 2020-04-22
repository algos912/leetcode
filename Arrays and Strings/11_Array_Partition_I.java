// TWO POINTER TECHNIQUE
// https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1154/
// Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
/*
Example 1:
Input: [1,4,3,2]
Output: 4

Explanation: 
n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).

Note:
n is a positive integer, which is in the range of [1, 10000].
All the integers in the array will be in the range of [-10000, 10000].
*/

// Minimum element gets add into the result in sacrifice of maximum element.
// Sort the array and try to find the pattern.

class Solution {
    public int arrayPairSum(int[] nums) {
        
        // check for invalid input
        if(nums == null || nums.length == 0)
            return 0;
        
        // sort the array
        Arrays.sort(nums);
        int output = 0;
        int min = 0;
        
        // iteration i= i+2 for sorted array numbers.
        for(int i = 0; i < nums.length; i=i+2) {
            
            /*
            //find min in the pair
            if(i+1 == nums.length)
                min = nums[i];
            if(nums[i] < nums[i+1])
                min = nums[i];
            else
                min = nums[i+1];
            output += min;
            */
            
            // add min number in each pair
            output += nums[i];
        }
        return output;
    }
}
