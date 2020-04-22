// https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1164/
// Given an input string, reverse the string word by word.

class Solution {
    public String reverseWords(String s) {
        // check for invalid inputs
        if(s == null || s.length() == 0)
            return "";
        
        // split words by space delimiter
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        
        // iterate from last word to first
        for(int i = words.length - 1; i >= 0; i--) {
            if(!words[i].equals("")) {
                sb.append(words[i]);
                sb.append(" ");
            }
        }
        
        // corner case: to handle string input " "
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
        
    }
}
