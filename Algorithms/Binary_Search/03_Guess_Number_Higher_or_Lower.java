// https://leetcode.com/explore/learn/card/binary-search/125/template-i/951/
/*
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
*/

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        
        //check for invalid inputs
        if(n < 1){
            return -1;
        }
        
        //binary search
        int lo = 1;
        int hi = n;
        int mid = 0;
        while(lo < hi) {
            mid = lo + (hi - lo) / 2;
            if(guess(mid) == 0)
                return mid;
            else if(guess(mid) == -1)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        
        //end condition
        return hi;  
    }
}
