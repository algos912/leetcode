// First Unique Character in a String
// https://leetcode.com/problems/first-unique-character-in-a-string/
/*
Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode"
return 2.
 

Note: You may assume the string contains only lowercase English letters.
*/

class Solution {
    public int firstUniqChar(String s) {
        
        // check for invalid inputs
        if(s == null || s.length() == 0)
            return -1;
        
        // build hashmap with char count
        HashMap<Character, Integer> sCountMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            sCountMap.put(curr, sCountMap.getOrDefault(curr,0) + 1);
        }
        
        // find the index of first single char
        for(int i = 0; i < s.length(); i++) {
            if(sCountMap.get(s.charAt(i)) == 1)
                return i;
        }
        
        return -1;
        
    }
}
