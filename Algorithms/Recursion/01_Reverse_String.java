// https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1440/
/*
Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.

 

Example 1:

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
*/

class Solution {
    public void reverseString(char[] s) {
        
        /*
        int len = s.length;
        int j = len-1;
        
        for (int i = 0; i < len/2; i++) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            
            j--;
        }
        */
        
        helper(0, s.length - 1, s);
    }
    
    private void helper(int start, int end, char [] s) {
      if (start >= end) {
        return;
      } 
      // swap between the first and the last elements.
      char tmp = s[start];
      s[start] = s[end];
      s[end] = tmp;
       
      helper(start + 1, end - 1, s);
   }
}
