// Two Sum II - Input array is sorted
// TWO POINTER TECHNIQUE
// https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1153/

/*
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:
Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.

Example:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]

Explanation: 
The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        // check for invalid inputs
        if(numbers == null || numbers.length == 0)
            return new int[] {};
        
        // binary search with two pointer-technique
        int start = 0;
        int end = numbers.length - 1;
        int sum = 0;
        while(start < end) {
            sum = numbers[start] + numbers[end];
            if(sum < target)
                start++;
            else if(sum > target)
                end--;
            else
                return new int[] {start+1, end+1};
        }
        
        // return empty array if there is no twoSum target
        return new int[] {};
    }
}
