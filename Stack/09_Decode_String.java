// Decode String
// https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1379/
// https://medium.com/@rebeccahezhang/leetcode-394-decode-string-6aafb1ad6bc3

/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
*/

class Solution {
    public String decodeString(String s) {
        
        // check invalid inputs
        if(s== null || s.length() == 0)
            return s;
        
        Stack<String> strStack = new Stack<String>();
        Stack<Integer> numStack = new Stack<Integer>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        
        while(i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                while (Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                numStack.push(num);
            } else if(s.charAt(i) == '[') {
                strStack.push(sb.toString());
                sb = new StringBuilder("");
                i++;
            } else if(s.charAt(i) == ']') {
                StringBuilder temp = new StringBuilder(strStack.pop());
                int repeatTimes = numStack.pop();
                for(int p = 0; p < repeatTimes; p++) {
                    temp.append(sb);
                }
                sb = temp;
                i++;
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
        
    }
}
