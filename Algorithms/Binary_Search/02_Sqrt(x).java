// https://leetcode.com/explore/learn/card/binary-search/125/template-i/950/
// Implement int sqrt(int x).

// Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

// Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

class Solution {
    public int mySqrt(int x) {
        
        // check for invalid inputs
        if(x < 0)
            return -1;
        if(x == 0)
            return 0;
        
        // binary search
        long lo = 0;
        long hi = x / 2 + 1; 
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long sq = mid * mid;
            if (sq == x) {
                return (int) mid;
            }
             
            if (sq < x) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        // end condition
        return (int) hi;
        
        
    }
}
