// Implement strStr()
// https://leetcode.com/problems/implement-strstr/
/*
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

 

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Example 3:

Input: haystack = "", needle = ""
Output: 0
*/

class Solution {
    public int strStr(String haystack, String needle) {
        
        // check for invalid inputs
        if( haystack == null || needle == null )
            return -1;
        
        int hayLen = haystack.length();
        int needleLen = needle.length();
        
        // corner cases
        if(needleLen == 0)
            return 0;
        if(haystack.equals(needle))
            return 0;
        if(hayLen < needleLen)
            return -1;
        
        //parse haystack for a copy of needle
        for(int i = 0; i <= hayLen - needleLen; i++){
            
            // when first needle character is matched
            if(haystack.charAt(i) == needle.charAt(0)) {
                int start = i;
                int j = 0;
                while(j < needleLen) {
                    if(haystack.charAt(i) != needle.charAt(j))
                        break;
                    else if (j == needleLen - 1)
                        return start; // return start index of needle
                    i++;
                    j++;
                }
                
                // reassign start to i
                i = start;  
            }
        }
        
        // no match found
        return -1;
        
    }
}
