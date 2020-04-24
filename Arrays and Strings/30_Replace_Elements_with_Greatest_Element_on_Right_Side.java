// https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3259/
// Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
// After doing so, return the array.

class Solution {
    public int[] replaceElements(int[] arr) {
        
        // check for invalid inputs
        if(arr == null || arr.length == 0)
            return new int[] {};
        
        //find maxNum in array
        int maxNum = 0;
        for(int i = 0; i < arr.length; i++) {
            // find maxNum for the rest of the array
            maxNum = 0;
            for(int j = i+1; j < arr.length; j++) {
                if(arr[j] > maxNum)
                    maxNum = arr[j];
            }
            
            //if last element, then set maxNum as -1
            if(i+1 == arr.length)
                maxNum = -1;
            
            //replace current element with maxNum
            arr[i] = maxNum;
        }
        return arr;
        
    }
}
