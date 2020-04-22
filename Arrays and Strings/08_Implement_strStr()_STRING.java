// https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1161/
/*
Implement strStr().
Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:
Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:
Input: haystack = "aaaaa", needle = "bba"
Output: -1

Clarification:
What should we return when needle is an empty string? This is a great question to ask during an interview.
For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
*/

class Solution {
    public int strStr(String haystack, String needle) {
        
        if(haystack == null || needle == null)
            return -1;
        
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        if(haystackLength < needleLength)
            return -1;
        if(needleLength == 0 || haystack.equals(needle))
            return 0;
        
        
        for(int i = 0; i <= haystackLength- needleLength; i++){
            
            //when first needle character is matched
            if (haystack.charAt(i) == needle.charAt(0)) {
                int start = i;
                int j = 0;
                while(j < needleLength-1) {
                    if(haystack.charAt(i) != needle.charAt(j))
                        break;
                    i++;
                    j++;
                }
                if (haystack.charAt(i) == needle.charAt(j) && j == needleLength-1)
                    return start;
                i = start;
            }
        }
        
        return -1; 
    }
}
