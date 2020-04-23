// https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1165/
// Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

// Idea: split string to String array, reverse each word and append each word to String builder.
class Solution {
    public String reverseWords(String s) {
        
        // check for invalid inputs
        if(s.length() == 0)
            return "";
        
        //split input string by space delimiter
        String[] words = s.trim().split(" ");
        
        //reverse each word and append it to output
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < words.length; i++) {
            String reversedWord = reverse(words[i].toCharArray());
            
            if(i == words.length - 1) {
                sb.append(reversedWord);
            } else {
                sb.append(reversedWord);
                sb.append(" ");
            }
        }
        return sb.toString();
        
    }
    
    // reverse char array in-place
    public String reverse(char[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while(i < j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            
            i++;
            j--;
        }
        return String.valueOf(arr);
    }
}
