// Longest Substring Without Repeating Characters

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

// TC : O(n)
// SC : O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        // check for invalid inputs
        if(s == null || s.length() == 0)
            return 0;
        
        HashSet<Character> set = new HashSet<Character>();
        int length = 0;
        int k = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            //if new non repeating character
            if(!set.contains(c)) {
                set.add(c);
                length = Math.max(length, set.size());
            } else {
                // repeating chars, clear set
                while (k < i) {
                    if(s.charAt(k) == c){
                        k++;
                        break;
                    }
                    set.remove(s.charAt(k));
                    k++;
                }
                
            }
        }
        return length;
        
    }
}
