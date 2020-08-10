// Strobogrammatic Number II
/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

Example:
Input:  n = 2
Output: ["11","69","88","96"]

Hint #1  
Try to use recursion and notice that it should recurse with n - 2 instead of n - 1.
*/

// solution explanation
// https://leetcode.com/problems/strobogrammatic-number-ii/discuss/138354/Logical-Thinking-with-Java-Code-Beats-100

public class Solution {
    public List<String> findStrobogrammatic(int n) {
        
        List<String> one = Arrays.asList("0", "1", "8"), two = Arrays.asList(""), r = two;
        if(n % 2 == 1)
            r = one;
        
        for(int i=(n % 2) + 2; i <= n; i += 2){
            List<String> newList = new ArrayList<>();
            for(String str : r){
                if(i != n)
                    newList.add("0" + str + "0");
                newList.add("1" + str + "1");
                newList.add("6" + str + "9");
                newList.add("8" + str + "8");
                newList.add("9" + str + "6");
            }
            r = newList;
        }
        return r;   
    }

}
