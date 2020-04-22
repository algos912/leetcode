// Given an array, rotate the array to the right by k steps, where k is non-negative.
// Could you do it in-place with O(1) extra space?
// https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1182/

// Solution using additional memory
class Solution {
    public void rotate(int[] nums, int k) {
        
        int len = nums.length;
        //check for invalid inputs
        if( len <= 1 || k == 0)
            return;
        
        //if k is greater than input array length
        if(k > len)
            k = k - len;
        
        //using an external array for storage
        int[] output = new int[len];
        int index = 0;
        for(int i = 0; i < len; i++) {
            if(i+k < len) {
                index = i + k;    
            } else {
                index = i + k - len;
            } 
            output[index] = nums[i];
        }
        
        //copy output array back to input array
        for(int i = 0; i < nums.length; i++) {
            nums[i] = output[i];
        }
        
    }
}
