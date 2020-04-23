// https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3251/
// Given an array A of integers, return true if and only if it is a valid mountain array.

class Solution {
    public boolean validMountainArray(int[] A) {
        
        // check for invalid inputs
        if(A == null || A.length < 3)
            return false;
        
        //find largest number in the array
        int maxNum = 0;
        int maxIndex = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] > maxNum) {
                maxNum = A[i];
                maxIndex = i;
            }
        }
        
        // corner case: if there is only up-slope or down-slope
        if(maxIndex == 0 || maxIndex == A.length-1)
            return false;
        
        //look for the mountain pattern
        for(int i = 0; i < A.length-1; i++) {
            if(i < maxIndex) {
                if(A[i] >= A[i+1])
                    return false;   
            } else if(i >= maxIndex) {
                if(A[i] <= A[i+1])
                    return false;
            }
        }
        return true;
        
    }
}
