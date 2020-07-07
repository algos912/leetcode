// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3382/
/*
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
*/

class Solution {
    public int[] plusOne(int[] digits) {
        
        // check for invalid inputs
        if(digits == null || digits.length == 0)
            return new int[] {};
        
        // plus one on input array
        int len = digits.length;
        int carry = 1;
        for(int i = len-1; i >= 0; i--){
            if(digits[i] + carry < 10) {
                digits[i] = digits[i] + carry;
                carry = 0;
            } else {
                digits[i] = 0;
                carry = 1;
            }
        }
        
        // if carry is 1, even after the most significant bit addition, create a new array
        // example: 999 + 1 = 1000
        if(carry == 1){
            int[] output = new int[len+1];
            output[0] = 1;
            return output;
        }else{
            return digits;
        }
    }
}
