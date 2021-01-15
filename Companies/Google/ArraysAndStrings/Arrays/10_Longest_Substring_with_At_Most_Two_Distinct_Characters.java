// Longest Substring with At Most Two Distinct Characters
// https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
/*
Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
Example 2:

Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.
*/

// sliding window
// TC : O(N)
// SC : O(1)

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        
        // check for invalid inputs
        if(s == null || s.length() == 0)
            return 0;
        
        //corner case
        int n = s.length();
        if(n < 3)
            return n;
        
        int left = 0;
        int right = 0;
        HashMap<Character,Integer> sMap = new HashMap<>(); // HashMap storing Character, rightmost position
        int maxLen = 2;
        
        while(right < n) {
            // when the slidewindow contains less than three characters
            sMap.put(s.charAt(right), right++);
            
            // when the slidewindow contains three characters
            if(sMap.size() == 3) {
                int i = Collections.min(sMap.values());
                sMap.remove(s.charAt(i)); // remove leftmost character
                left = i+1;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}
