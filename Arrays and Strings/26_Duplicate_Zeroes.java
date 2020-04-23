// https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3245/
// Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
// Note that elements beyond the length of the original array are not written.
// Do the above modifications to the input array in place, do not return anything from your function.

class Solution {
    public void duplicateZeros(int[] arr) {
        
        // check for invalid inputs
        if(arr == null || arr.length == 0)
            return;
        
        // 1. Solution using additional array to copy the values
        // SC : O(n), TC: O(n)
        int[] output = new int[arr.length];
        int k = 0;
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
        
        // 2. in-place swapping
        // TC: O(n2), SC : O(1)
        /*
        int tmp = 0;
        int tmp2 = 0;
        
        for(int i = 0; i < arr.length; i++) {
            
            // if value is zero
            if (arr[i] == 0 && i+1 < arr.length){
                tmp = arr[i+1]; //save next value to tmp
                arr[i+1] = 0; // set next value to zero
                
                //move all the remaining values by one place to right
                for(int j = i+2; j < arr.length; j++) {
                    tmp2 = arr[j];
                    arr[j] = tmp;
                    tmp = tmp2;
                }
                //increment i
                i++;
            }
            
        }
        */
        
    }
}
