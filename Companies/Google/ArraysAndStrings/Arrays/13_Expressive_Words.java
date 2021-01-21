// Expressive Words
/*
Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo", "hi" -> "hiiii".  In these strings like "heeellooo", we have groups of adjacent letters that are all the same:  "h", "eee", "ll", "ooo".

For some given string S, a query word is stretchy if it can be made to be equal to S by any number of applications of the following extension operation: choose a group consisting of characters c, and add some number of characters c to the group so that the size of the group is 3 or more.

For example, starting with "hello", we could do an extension on the group "o" to get "hellooo", but we cannot get "helloo" since the group "oo" has size less than 3.  Also, we could do another extension like "ll" -> "lllll" to get "helllllooo".  If S = "helllllooo", then the query word "hello" would be stretchy because of these two extension operations: query = "hello" -> "hellooo" -> "helllllooo" = S.

Given a list of query words, return the number of words that are stretchy. 

 

Example:
Input: 
S = "heeellooo"
words = ["hello", "hi", "helo"]
Output: 1
Explanation: 
We can extend "e" and "o" in the word "hello" to get "heeellooo".
We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.
 

Constraints:

0 <= len(S) <= 100.
0 <= len(words) <= 100.
0 <= len(words[i]) <= 100.
S and all words in words consist only of lowercase letters
*/

class Solution {
    public int expressiveWords(String S, String[] words) {
        
        // check for invalid inputs
        if(words == null || S == null || words.length == 0)
            return 0;
        
        int count = 0;
        for(int i = 0; i < words.length; i++) {
            if(isStretchy(S, words[i]))
                count++;
        }
        return count;
        
    }
    
    // check if a word is stretchy
    public boolean isStretchy(String S, String word) {
        int i = 0, j = 0;
        while (i < S.length() && j < word.length()) {
            
            // characters don't match
            if(S.charAt(i) != word.charAt(j))
                return false;
            
            // count block size starting at S.charAt(i)
            int sBlockSize = 1;
            i++;
            while(i < S.length() && S.charAt(i-1) == S.charAt(i)) {
                sBlockSize++;
                i++;
            }
            
            // count block size starting at word.charAt(j)
            int wordBlockSize = 1;
            j++;
            while(j < word.length() && word.charAt(j-1) == word.charAt(j)) {
                wordBlockSize++;
                j++;
            }
            
            // check if any violation is encountered
            if (sBlockSize < wordBlockSize || (wordBlockSize < sBlockSize && sBlockSize < 3)) {
                return false;
            } 
        }
        
        // return true if we managed to map all characters without encountering a violation
        return i == S.length() && j == word.length();
    }
}
