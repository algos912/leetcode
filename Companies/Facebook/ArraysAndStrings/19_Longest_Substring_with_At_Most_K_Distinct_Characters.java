// Longest Substring with At Most K Distinct Characters
// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3017/
/*
Given a string, find the length of the longest substring T that contains at most k distinct characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.
*/

// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/discuss/80047/15-lines-java-solution-using-slide-window

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        int[] count = new int[256];     // there are 256 ASCII characters in the world
    
        int i = 0;  // i will be behind j
        int num = 0;
        int res = 0;
    
        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)]++ == 0) {    // if count[s.charAt(j)] == 0, we know that it is a distinct character
                num++;
            }
            while (num > k && i < s.length()) {     // sliding window
                count[s.charAt(i)]--;
                if (count[s.charAt(i)] == 0){ 
                    num--;
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
