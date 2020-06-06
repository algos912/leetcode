// https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1117/

/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.
*/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        // check for invalid inputs
        if(s == null || t == null)
            return false;
        
        //edge cases
        if(s.length() == 0 && t.length() == 0)
            return true;
        if(s.length() == 1 && t.length() == 1)
            return true;
        if(s.length() != t.length())
            return false;
        
        HashMap<Character,Character> sMap = new HashMap<Character,Character>();
        HashMap<Character,Character> tMap = new HashMap<Character,Character>();
        for(int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            
            if(sMap.containsKey(c1)) {
                if(c2 != sMap.get(c1))
                    return false;
            } else {
                if(tMap.containsKey(c2))
                    return false;
                
                sMap.put(c1,c2);
                tMap.put(c2,c1);
            }
        }
        return true;
        
    }
}
