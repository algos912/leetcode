// https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3237/
// Given an array nums of integers, return how many of them contain an even number of digits.

class Solution {
    public int findNumbers(int[] nums) {
        
        //check for invalid inputs
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        // int num = 0;
        // int digits = 0;
        int evenDigitsNums = 0;
        for(int i = 0; i < nums.length; i++) {
            
            /*
            // BRUTE FORCE : TIME LIMIT EXCEEDED error
            // find number of digits in each
            num = nums[i];
            digits = 0;
            while(num > 10) {
                num = nums[i] / 10;
                digits++;
            }
            
            
            //if number of digits is even
            if(digits % 2 == 0){
                evenDigitsNums++;
            }
            */
            
            //convert integer to string and find length of that string
            if (Integer.toString(nums[i]).length() % 2 == 0) {
                evenDigitsNums++;
            }
            
        }
        return evenDigitsNums;
        
    }
}
