// https://leetcode.com/explore/learn/card/binary-search/144/more-practices/1034/
// Given two arrays, write a function to compute their intersection.

TC: O(n)
SC : O(n)

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
        
        // convert set to array
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
