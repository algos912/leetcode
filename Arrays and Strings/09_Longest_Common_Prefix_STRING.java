// https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1162/
/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: ["dog","racecar","car"]
Output: ""

Explanation: There is no common prefix among the input strings.
Note: All given inputs are in lowercase letters a-z.
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        // check for invalid inputs
        if(strs == null || strs.length == 0)
            return "";
        
        // corner case: for only one value
        if(strs.length == 1)
            return strs[0];
        
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            int j = 0;
            String cur = strs[i];
            
            // check if character at index j, is same for cur and prefix words
            while(j < prefix.length() && j < cur.length() && prefix.charAt(j) == cur.charAt(j)) {
                j++;
            }
            
            if(j== 0)
                return "";
            prefix = prefix.substring(0,j);
        }
        return prefix;
    }
}
