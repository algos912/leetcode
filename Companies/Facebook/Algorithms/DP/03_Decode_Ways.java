// Decode Ways
// https://leetcode.com/explore/interview/card/facebook/55/dynamic-programming-3/264/
/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

Similar questions:
62. Unique Paths
70. Climbing Stairs
509. Fibonacci Number

Practice them in a row for better understanding 😉
*/

class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        dp[0] = chars[0] == '0' ? 0 : 1;
        for (int i = 1; i < chars.length; i++) {
            char current = chars[i];
            char prev = chars[i - 1];
            if (current >= '1' && current <= '9') {
                dp[i] = dp[i - 1];
            }
            if ((prev == '1' && current >= '0' && current <= '9') ||
                    (prev == '2' && current >= '0' && current <= '6')) {
                dp[i] += i >= 2 ? dp[i - 2] : 1;
            }
        }
        return dp[chars.length - 1];
    }
}

