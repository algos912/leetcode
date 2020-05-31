// https://leetcode.com/problems/generate-parentheses/
// https://www.programcreek.com/2014/01/leetcode-generate-parentheses-java/
/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<String>();
        dfs(output, "", n, n);
        return output;
    }
    
    /*
    left and right represents the remaining number of ( and ) that need to be added. 
    When left > right, there are more ")" placed than "(". Such cases are wrong and the method stops. 
    */
    public void dfs(List<String> output, String s, int left, int right) {
        if(left > right)
            return;
        
        if(left == 0 && right == 0) {
            output.add(s);
            return;
        }
        
        if(left > 0) {
            dfs(output, s+"(", left-1, right);
        }
        
        if(right>0){
            dfs(output, s+")", left, right-1);
        }
    }
}
