// https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1120/

/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
 

Note: You may assume the string contain only lowercase English letters.
*/

class Solution {
    public int firstUniqChar(String s) {
        
        // check for invalid inputs
        if(s == null || s.length() == 0)
            return -1;
        
        // fill in hashMap with each character and its frequency
        HashMap<Character,Integer> charMap = new HashMap<Character,Integer>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c)+1);
            } else {
                charMap.put(c, 1);
            }   
        }
        
        // return first character whose frequency is one
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(charMap.get(c) == 1)
                return i;
        }
        
        // not found
        return -1;
        
    }
}
