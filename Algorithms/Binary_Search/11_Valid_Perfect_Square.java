// https://leetcode.com/explore/learn/card/binary-search/137/conclusion/978/
// Given a positive integer num, write a function which returns True if num is a perfect square else False.
// Follow up: Do not use any built-in library function such as sqrt.

class Solution {
    public boolean isPerfectSquare(int num) {
        
        boolean output = false;
        // edge cases
        if (num < 0)
            return false;
        if (num == 0 || num == 1)
            return true;
        
        long start = 1;
        long end = (long) num;
        long mid = 0;
        long square = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            square = mid * mid;
            if(square == num)
                return true;
            else if (square > num)
                end = mid - 1;  
            else 
                start = mid + 1;
        }
        return output;
        
        
    }
}
