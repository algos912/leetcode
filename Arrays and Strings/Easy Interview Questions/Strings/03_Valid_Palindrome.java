// Valid Palindrome
// https://leetcode.com/problems/valid-palindrome/
/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 

Constraints:

s consists only of printable ASCII characters.
*/

class Solution {
    public boolean isPalindrome(String s) {
        
        // check for invalid inputs
        if(s == null )
            return false;
        
        // corner case -empty string
        if(s.length() == 0)
            return true;
        
        // build alphanumeric string
        StringBuilder build = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(Character.isLetterOrDigit(c))
                build.append(Character.toLowerCase(c));
        }
        
        // compare original and reversed strings are equal, then it is a palindrome
        String original = build.toString();
        String reversed = build.reverse().toString();
        return original.equals(reversed);
    }
}
