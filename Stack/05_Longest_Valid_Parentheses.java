// https://www.programcreek.com/2014/06/leetcode-longest-valid-parentheses-java/
// https://leetcode.com/problems/longest-valid-parentheses/
/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"
*/

// A stack can be used to track and reduce pairs. 
// Since the problem asks for length, we can put the index into the stack along with the character. 
// For coding simplicity purpose, we can use 0 to respresnt ( and 1 to represent ).

class Solution {
    public int longestValidParentheses(String s) {
        
        int output = 0;
        Stack<int[]> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ')') {
                if(!stack.isEmpty() && stack.peek()[0] == 0) {
                    stack.pop();
                    output = Math.max(output, i - (stack.isEmpty() ? -1 : stack.peek()[1]));
                } else {
                    stack.push(new int[] {1,i});
                }
            } else {
                stack.push(new int[] {0, i});
            }
        }
        
        //return length of longest valid parantheses
        return output;
        
    }
}
