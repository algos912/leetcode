// https://leetcode.com/explore/learn/card/binary-search/137/conclusion/982/
// Implement pow(x, n), which calculates x raised to the power n (xn).

class Solution {
    public double myPow(double x, int n) {
        
        double output = 0;
        
        //edge cases
        if(x == 1 || x == 0) return x;
        if(x == -1) return n % 2 == 0 ? 1 : -1;
        if(n == 1) return x;
        
        if (n > 0) {
            int loop = 1;
            while (n > 0) {
                if(loop == 1) {
                    output = x;
                } else {
                    output *= x;
                }
                loop++;
                n--;
            }
        } else if ( n < 0) {
            int loop = 1;
            n = n * -1;
            while (n > 0) {
                if(loop == 1) {
                    output = 1 / x;
                } else {
                    output /= x;
                }
                loop++;
                n--;
            }
        } else if (n == 0) {
            output = 1;
        }
        
        // return power of x
        return output;
        
    }
}
