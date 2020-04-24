// https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3253/
// Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
/*
Note:
The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.

Example:
Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3
Output: [1,2,2,3,5,6]
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        // check for invalid inputs
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return;
        
        // merge
        // 1. Solution using an extra array
        int i = 0, j = 0, k = 0;
        int[] output = new int[nums1.length];
        while (i < nums1.length && j < nums2.length && k < nums1.length) {
            if(nums1[i] < nums2[j] && i < m){
                output[k] = nums1[i];
                k++;
                i++;
            } else {
                output[k] = nums2[j];
                k++;
                j++;
            }
        }
        
        // fill in remaining elements of nums1 or nums2 to output
        while (k < nums1.length) {
            if (i < nums1.length) {
                output[k] = nums1[i];
                k++;
                i++;
            } 
        }
        // copy back output to nums1 array
        for(int p = 0; p < nums1.length; p++) {
            nums1[p] = output[p];
        }
        
    }
}
