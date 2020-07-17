// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3008/
/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        // check for invalid inputs
        if(s == null || s.length() == 0)
            return 0;
        
        HashSet<Character> set = new HashSet<Character>();
        int length = 1;
        int i = 0;
        for(int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            
            // non repeating characters
            if(!set.contains(c)) {
                set.add(c);
                length = Math.max(length,set.size());
            } else {
                // clear set if repeating characters
                while(i < j) {
                    if(s.charAt(i) == c) {
                        i++;
                        break;
                    }
                    set.remove(s.charAt(i));
                    i++;
                }
            }
        }
        return length;
        
    }
}
