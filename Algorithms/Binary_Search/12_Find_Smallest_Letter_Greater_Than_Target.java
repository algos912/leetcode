// https://leetcode.com/explore/learn/card/binary-search/137/conclusion/977/
/*
Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
*/

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {

        for ( int i = 0; i < letters.length; i++) {
            if(letters[i] > target) {
                return letters[i];
            }
        }
        return letters[0];
        
        // Binary Search
        /*
        int low = 0;
        int high = letters.length - 1;
        int mid = 0;
        while(low < high){
            mid = low + (high - low) / 2;
            if(letters[mid] > target) high = mid;
            else low = mid + 1;
        }
        return low == letters.length - 1 && letters[low] <= target ? letters[0] : letters[low];
        */
        
    }
}
