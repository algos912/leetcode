// https://leetcode.com/explore/learn/card/binary-search/146/more-practices-ii/1040/
/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        // combine both arrays into one
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m+n];
        for(int i = 0; i < nums1.length; i++){
            nums[i] = nums1[i];
        }
        for(int i = 0; i < nums2.length; i++){
            nums[nums1.length + i] = nums2[i];
        }
        
        //find median of combined array
        Arrays.sort(nums);
        int len = nums.length;
        if(len % 2 == 0) {
            return (nums[len/2] + nums[len/2 - 1]) * 1.0 / 2;
        } else {
            return nums[len/2] * 1.0;
        } 
    }
}
