// Given an array, rotate the array to the right by k steps, where k is non-negative.
// https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1182/

class Solution {
    public void rotate(int[] nums, int k) {
        
        if(nums == null || nums.length == 0 || k == 0)
            return;
        
        // Solution 1 : use additional memory
        // TC : O(n)
        // SC : O(n)
        /*
        int[] buffer = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            buffer[(i+k) % nums.length] = nums[i];
        }
        
        for(int i = 0; i < nums.length; i++) {
            nums[i] = buffer[i];
        }
        */
        
        // Solution 2 : in-place
        // TC : O(n)
        // SC : O(1)
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        
    }
    
    //reverse array in-place
    public void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }
}
