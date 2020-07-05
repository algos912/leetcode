// https://leetcode.com/explore/learn/card/hash-table/185/hash_table_design_the_key/1125/
// https://tenderleo.gitbooks.io/leetcode-solutions-/GoogleEasy/249.html
/*
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of non-empty strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

Example:

Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
Output: 
[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
*/
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        
        // check for invalid inputs
        if(strings == null || strings.length == 0)
            return new ArrayList();
        
        HashMap<String,List<String>> map = new HashMap<String,List<String>>();
        for(String s : strings) {
            String hash = getHash(s);
            if(map.containsKey(hash)){
                map.get(hash).add(s);
            } else {
                List<String> l = new ArrayList<>();
                l.add(s);
                map.put(hash,l);
            }
        }
        // return output
        return new ArrayList<List<String>>(map.values());
        
    }
    
    String getHash(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            sb.append((s.charAt(i) - s.charAt(0) + 26) % 26);
            sb.append("."); // to make sure there is no overlap
        }
        return sb.toString();
    }
}
