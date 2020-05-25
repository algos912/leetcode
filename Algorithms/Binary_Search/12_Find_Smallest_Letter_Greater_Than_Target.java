// https://leetcode.com/explore/learn/card/binary-search/137/conclusion/977/
/*
Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
*/

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {

        // linear search
        /*
        for ( int i = 0; i < letters.length; i++) {
            if(letters[i] > target) {
                return letters[i];
            }
        }
        return letters[0];
        */
        
        // binary search
        int start = 0;
        int end = letters.length - 1;
        int mid = 0;
        while (start < end) {
            mid = start + (end - start) / 2;
            if(letters[mid] > target)
                end = mid;
            else
                start = mid + 1;
        }
        // post-processing
        if (start == letters.length - 1 && letters[start] <= target)
            return letters[0];
        else
            return letters[start];
        
    }
}
