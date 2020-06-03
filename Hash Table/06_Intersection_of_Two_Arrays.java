// https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1105/
// Given two arrays, write a function to compute their intersection.

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        // check for invalid inputs
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[] {};
        
        HashSet<Integer> set1 = new HashSet<Integer>();
        for(int i : nums1) {
            set1.add(i);            
        }
        
        // finding intersection using set
        HashSet<Integer> set2 = new HashSet<Integer>();
        for(int i : nums2) {
            if(set1.contains(i)) {
                set2.add(i);
            }
        }
        
        // convert set2 to array
        int[] output = new int[set2.size()];
        int index = 0;
        for(int i : set2) {
            output[index] = i;
            index++;
        }
        
        // return the array output
        return output;
        
    }
}
