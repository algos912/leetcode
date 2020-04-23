// https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3245/
// Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
// Note that elements beyond the length of the original array are not written.
// Do the above modifications to the input array in place, do not return anything from your function.

class Solution {
    public void duplicateZeros(int[] arr) {
        
        // check for invalid inputs
        if(arr == null || arr.length == 0)
            return;
        
        int k = 0;
        //1. Solution using additional array to copy the values
        // SC : O(n), TC: O(n)
        int[] output = new int[arr.length];
        for(int i = 0; i < arr.length && k < arr.length; i++) {
            output[k] = arr[i];
            k++;
            if(k >= arr.length)
                break;
            
            if(arr[i] == 0){
                output[k] = 0;
                k++;
            }
        }
        
        // Copy back output array to input array
        for(int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
        
    }
}
