// TWO POINTER TECHNIQUE
// https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1183/
// Write a function that reverses a string. The input string is given as an array of characters char[].
// Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

/*
Example 1:
Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:
Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
*/

class Solution {
    public void reverseString(char[] s) {
        
        //reverse in-place
        int len = s.length;
        int j = len-1;
        for (int i = 0; i < len/2; i++) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            
            j--;
        }
    }
}
