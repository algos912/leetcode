// Given an array, rotate the array to the right by k steps, where k is non-negative.
// https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1182/

class Solution {
    public void rotate(int[] nums, int k) {
        
        int len = nums.length;
        //check for invalid inputs
        if( len <= 1 || k == 0)
            return;
        
        //if k is greater than input array length
        if(k > len)
            k = k - len;
        
        // 1. Solution using additional memory
        // using an external array for storage
        // Space : O(n)
        // Time : O(n)
        
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
        
        // Copy output array back to input array
        for(int i = 0; i < nums.length; i++) {
            nums[i] = output[i];
        }
        
        // Could you do it in-place with O(1) extra space?
        // 2. Bubble rotate (like bubble sort)
        // Space : O(1)
        // Time : O(n*k)
        
        /*
        for(int i = 0; i < k; i++) {
            for(int j = len-1; j > 0; j--) {
                int tmp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = tmp;
            }
        }
        */
        
        // 3. Use Array Reverse
        // Space : O(1)
        // Time : O(n)
        
        // Assuming we are given {1,2,3,4,5,6} and order 2. The basic idea is:
        // 1. Divide the array two parts: 1,2,3,4 and 5, 6
        // 2. Reverse first part: 4,3,2,1,5,6
        // 3. Reverse second part: 4,3,2,1,6,5
        // 4. Reverse the whole array: 5,6,1,2,3,4
         
        /*
        //find length of first part
        int firstPartLength = len - k;
        
        reverse(nums, 0, firstPartLength-1);
        reverse(nums, firstPartLength, len-1);
        reverse(nums, 0, len-1);
        */
        
    }
    
    //reverse array in-place
    public void reverse(int[] arr, int start, int end) {
        
        if(arr == null || arr.length == 1) 
            return;
        
        while (start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            
            start++;
            end--;
        }
    }
}
