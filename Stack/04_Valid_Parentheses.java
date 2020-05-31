// https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1361/
/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
*/

class Solution {
    public boolean isValid(String s) {
        
        HashMap<Character,Character> map = new HashMap<Character,Character>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            if(map.keySet().contains(curr)) {
                // if curr is an opening paranthesis
                stack.push(curr);
            } else if(map.values().contains(curr)) {
                // if curr is a closing paranthesis
                if(!stack.empty() && map.get(stack.peek()) == curr) {
                    stack.pop();
                } else {
                    return false;
                }  
            }
        }
        
        // return true only if the stack is empty
        return stack.empty();
        
    }
}
