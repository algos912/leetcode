// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3015/
/*
Given two strings s and t, determine if they are both one edit distance apart.

Note: 

There are 3 possiblities to satisify one edit distance apart:

Insert a character into s to get t
Delete a character from s to get t
Replace a character of s to get t

Example 1:
Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.

Example 2:
Input: s = "cab", t = "ad"
Output: false
Explanation: We cannot get t from s by only one step.

Example 3:
Input: s = "1203", t = "1213"
Output: true
Explanation: We can replace '0' with '1' to get t.
*/

class Solution {
    public boolean isOneEditDistance(String s, String t) {
        
        int m = s.length();
        int n = t.length();
        if (m > n) 
            return isOneEditDistance(t, s);
        if (n - m > 1) 
            return false;
   
        int i = 0, shift = n - m;
        while (i < m && s.charAt(i) == t.charAt(i)) 
            i++;
        if (i == m) return shift > 0;
        if (shift == 0) i++;
        
        while (i < m && s.charAt(i) == t.charAt(i + shift)) 
            i++;
        
        return i == m;
        
    }
}
