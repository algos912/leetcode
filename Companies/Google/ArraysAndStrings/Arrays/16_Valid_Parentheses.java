// Valid Parentheses
/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/

// Using hashMap and stack
// TC : O(N)
// SC : O(N)

class Solution {
    public boolean isValid(String s) {
        
        // check for invalid inputs
        if(s == null || s.length() == 0)
            return false;
        
        HashMap<Character, Character> pMap = new HashMap<Character, Character>();
        pMap.put(')', '(');
        pMap.put('}', '{');
        pMap.put(']', '[');
        
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // if current character is a closing bracket
            if(pMap.containsKey(c)) {
                //get top element of stack
                //if stack is empty, set a dummy value of "#"
                char topElement = stack.empty() ? '#' : stack.pop();
                if(topElement != pMap.get(c))
                    return false;
            // if current character is an opening bracket
            } else {
                stack.push(c);
            }
        }
        
        // if stack is empty, valid paranthesis
        return stack.isEmpty();
    }
}
