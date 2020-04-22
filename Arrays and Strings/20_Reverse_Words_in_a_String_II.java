// https://www.programcreek.com/2014/05/leetcode-reverse-words-in-a-string-ii-java/
// Given an input string, reverse the string word by word. 
// Could you do it in-place without allocating extra space?

// The basic idea is to reverse the whole string firstly, then reverse each word. 
// Given s = “the sky is blue“, we reverse it to be “eulb si yks eht“. Then we reverse each word to get “blue is sky the“.

// Idea: Reverse twice, both in place.
// Time: O(n) 
// Space: O(1)

public class Solution {
    public void reverseWords(char[] s) {
        // Corner case
        if (s == null || s.length == 0) {
            return;
        }
        
        // Firstly reverse the whole string
        reverse(s, 0, s.length - 1);
        
        // Then reverse each word
        for (int start = 0, i = 0; i <= s.length; i++) {
            // look for each blank space, to delimit each word
            if (i == s.length || s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
    }
    
    // Reverse each char from start to end
    public static void reverse(char[] s, int start, int end) {
        while (start < end) {
            char c = s[start];
            s[start] = s[end];
            s[end] = c;
            
            start++; 
            end--;
        }
    }
}
