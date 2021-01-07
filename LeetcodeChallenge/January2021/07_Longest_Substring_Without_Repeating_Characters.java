// Longest Substring Without Repeating Characters
// https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3595/
/*

Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/

// Sliding window using HashSet
// TC : O(n)
// SC : O(n), since hashSet is used

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        // check for invalid inputs
        if(s == null || s.length() == 0)
            return 0;
        
        
        HashSet<Character> set = new HashSet<>();
        int maxCount = 0, i = 0, j = 0, len = s.length();
        while(i < len && j < len) {
                // unique character
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                maxCount = Math.max(maxCount, j-i);
            } else {
                // repeating character
                set.remove(s.charAt(i));
                i++;
            }
        }
        return maxCount;
        
    }
}
