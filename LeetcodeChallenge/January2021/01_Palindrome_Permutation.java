// Palindrome Permutation
// https://leetcode.com/explore/featured/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3588/
/*
Given a string, determine if a permutation of the string could form a palindrome.

Example 1:

Input: "code"
Output: false
Example 2:

Input: "aab"
Output: true
Example 3:

Input: "carerac"
Output: true
   Hide Hint #1  
Consider the palindromes of odd vs even length. What difference do you notice?
   Hide Hint #2  
Count the frequency of each character.
   Hide Hint #3  
If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?
*/

// TC : O(n)
// SC: O(n) , since I used HashMap to keep character count

class Solution {
    public boolean canPermutePalindrome(String s) {
        
        // check for invalid inputs
        if(s == null || s.length() == 0)
            return false;
        
        int even = 0;
        if(s.length() % 2 == 0)
            even = 1;
        
        // build character count
        HashMap<Character,Integer> charMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charMap.put(c, charMap.getOrDefault(c,0)+1);
        }
        
        // check count of each character in hashMap
        int oddCount = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = charMap.get(c);
            if(even == 1){
                if(count % 2 != 0)
                    return false;
            } else if(even == 0) {
                if(count == 1 && oddCount == 0) {
                    oddCount = 1;
                } else if (count == 1 && oddCount == 1) {
                    // more than one odd count characters
                    return false;
                }
            }
        }
        
        // no problems detected
        return true;
        
    }
}
