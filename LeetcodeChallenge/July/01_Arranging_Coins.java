// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3377/
// You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
// Given n, find the total number of full staircase rows that can be formed.
/*
Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.
*/

class Solution {
    public int arrangeCoins(int n) {
        
        // Math equation
        // return (int)(Math.sqrt(2 * (long)n + 0.25) - 0.5);
        
        // binary search
        long left = 0;
        long right = n;
        long mid = 0;
        long curr;
        while(left <= right) {
            mid = left + (right - left)/ 2;
            curr = mid * (mid + 1 )/ 2;
            
            if(curr == n)
                return (int)mid;
            
            if(curr > n)
                right = mid - 1;
            else if(curr < n)
                left = mid + 1;
        }
        
        return (int)right;
        
    }
}
