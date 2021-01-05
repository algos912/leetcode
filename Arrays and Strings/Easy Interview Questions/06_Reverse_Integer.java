// https://leetcode.com/problems/reverse-integer/

/*
iven a 32-bit signed integer, reverse digits of an integer.

Note:
Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
Example 4:

Input: x = 0
Output: 0
*/

class Solution {
    public int reverse(int x) {
        
        int reverse = 0;
        while(x != 0) {
            // get last digit using pop
            int pop = x % 10;
            x /= 10;
            
            // check if reversed integer overflows
            // positive reversed integer
            if(reverse > Integer.MAX_VALUE/10 || 
              (reverse == Integer.MAX_VALUE/10 && pop > 7)) {
                return 0;
            }
            // check negative reversed integer
            if(reverse < Integer.MIN_VALUE/10 ||
              (reverse == Integer.MIN_VALUE/10 && pop < -8)) {
                return 0;
            }
            
            // push last digit as beginning of output
            reverse = reverse * 10 + pop;
        }
        return reverse;
    }
}
