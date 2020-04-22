// https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1160/
// Given two binary strings, return their sum (also a binary string).
// The input strings are both non-empty and contains only characters 1 or 0.

/*
Constraints:
Each string consists only of '0' or '1' characters.
1 <= a.length, b.length <= 10^4
Each string is either "0" or doesn't contain any leading zero.

Example 1:
Input: a = "11", b = "1"
Output: "100"

Example 2:
Input: a = "1010", b = "1011"
Output: "10101"
*/

class Solution {
    public String addBinary(String a, String b) {
        
        StringBuilder sb = new StringBuilder();
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        
        for (int i = ac.length-1, j = bc.length-1, carry = 0; i >= 0 || j >= 0 || carry != 0; i--, j--)         {
            int m = (i < 0) ? 0 : ac[i]-'0';
            int n = (j < 0) ? 0 : bc[j]-'0';
            int total = m+n+carry;
            sb.append(total % 2);
            carry = total / 2;
        }
        return sb.reverse().toString();
        
        /*
        if(a == null || a.length() == 0){
            return b;
        }
        if(b == null || b.length() == 0){
            return a;
        }
        
        int lastIndexA = a.length() - 1;
        int lastIndexB = b.length() - 1;
        
        int flag = 0;
        StringBuilder sb = new StringBuilder();
        int valueOfA = 0;
        int valueOfB = 0;
        while(lastIndexA >= 0 || lastIndexB >= 0) {
            valueOfA = 0;
            valueOfB = 0;
            
            if(lastIndexA >= 0){
                valueOfA = a.charAt(lastIndexA) == '0' ? 0 : 1;
                lastIndexA--;
            }
            if(lastIndexB >= 0){
                valueOfB = b.charAt(lastIndexB) == '0' ? 0 : 1;
                lastIndexB--;
            }
            
            int sum = valueOfA + valueOfB + flag;
            if(sum >= 2) {
                sb.append(String.valueOf(sum-2));
                flag = 1;
            } else {
                flag = 0;
                sb.append(String.valueOf(sum));
            }
        }
        
        if (flag == 1){
            sb.append("1");
        }
        String reversed = sb.reverse().toString();
        return reversed;
        */
        
    }
}
