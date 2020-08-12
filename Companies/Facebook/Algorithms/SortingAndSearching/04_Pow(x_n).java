// Pow(x, n)
/*
Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100
Example 3:

Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
Note:

-100.0 < x < 100.0
n is a 32-bit signed integer, within the range [−231, 231 − 1]
*/

class Solution {
    
    // SOLUTION 1 : BRUTE FORCE : TLE
    /*
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
    */
    
    // SOLUTION 2 : FAST POWER ALGORITHM RECURISIVE
    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }
}
