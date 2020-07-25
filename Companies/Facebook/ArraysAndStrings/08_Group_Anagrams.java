// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3014/
/*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note:
All inputs will be in lowercase.
The order of your output does not matter.
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // check for inavlid input
        if(strs.length == 0)
            return new ArrayList();
        
        HashMap<String,List> map = new HashMap<String,List>();
        for(String s : strs) {
            char[] word = s.toCharArray();
            Arrays.sort(word);
            String key = String.valueOf(word);
            
            // add key to the map
            if(!map.containsKey(key))
                map.put(key, new ArrayList());
            // add values to the map for the specific key
            map.get(key).add(s);
            
        }
        return new ArrayList(map.values());
    }
}
