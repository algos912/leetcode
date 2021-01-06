// Valid Anagram
// https://leetcode.com/problems/valid-anagram/
/*
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        
        // check for invalid inputs
        if(s == null || t == null )
            return false;
        
        // corner case
        if(s.length() != t.length())
            return false;
        if(s.length() == 0 || t.length() == 0)
            return true;
        
        // build hashMap with char count
        HashMap<Character,Integer> sMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }
        
        // check hashMap for second string chars
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(sMap.containsKey(c)) {
                int count = sMap.get(c);
                if(count-1 == 0) {
                    sMap.remove(c);
                } else {
                    sMap.put(c, count-1);
                }
                System.out.println(sMap);
        
            } else {
                return false;
            }
        }
        
        // check is hashMap is empty
        if(sMap.isEmpty())
            return true;
        else
            return false;
        
    }
}
