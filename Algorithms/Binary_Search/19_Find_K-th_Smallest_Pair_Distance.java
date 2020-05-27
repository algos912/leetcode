// https://leetcode.com/explore/learn/card/binary-search/146/more-practices-ii/1041/
// Given an integer array, return the k-th smallest distance among all the pairs. 
// The distance of a pair (A, B) is defined as the absolute difference between A and B.

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        
        // check for invalid inputs
        if(nums == null || nums.length == 0)
            return 0;
        
        // binary search
        Arrays.sort(nums);
        // Minimum absolute difference
        int start = 0;
        // Maximum absolute difference
        int end = nums[nums.length - 1] - nums[0];
        int mid = 0;
        while(start <= end) {
            mid = start + (end - start)/ 2;

            if(pairsCount(nums, mid) >= k)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start; 
    }
    
    // With the help of Sorted Matrix, we can calculate
    // the number of pairs with absolute difference less than or equal to mid in O(n).
    public int pairsCount(int[] nums, int target) {
        int n = nums.length;
        int count = 0;
        
        // col pointer move from left to right (smaller -> bigger)
        for (int row = 0, col = 1; row < n - 1; row++) {
            while (col < n && nums[col] - nums[row] <= target) {
                col++;
            }
            count += col - row - 1;
        }
        return count;
    }
}
