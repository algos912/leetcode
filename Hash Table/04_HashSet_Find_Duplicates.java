// Find Duplicates By Hash Set
// https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1102/
// Given an array of integers, find if the array contains any duplicates. 

class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        // check for invalid inputs
        if(nums == null || nums.length == 0)
            return false;
        
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i : nums){
            if(set.contains(i))
                return true;
            else
                set.add(i);
        }
        return false;
        
    }
}
