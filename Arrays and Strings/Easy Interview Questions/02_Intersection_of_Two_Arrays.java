// Intersection of Two Arrays
/*
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:

Each element in the result must be unique.
The result can be in any order.
*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        HashSet<Integer> set1 = new HashSet<Integer>();
        for(Integer n : nums1)
            set1.add(n);
        
        HashSet<Integer> set2 = new HashSet<Integer>();
        for(Integer n : nums2) {
            if(set1.contains(n))
                set2.add(n);
        }
        
        int[] output = new int[set2.size()];
        int j = 0;
        for(int number : set2)
            output[j++] = number;
        
        return output;
    }
}
