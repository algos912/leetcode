// https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3240/
// Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

class Solution {
    public int[] sortedSquares(int[] A) {
        
        // check for invalid inputs
        if(A == null || A.length == 0)
            return new int[] {};
        
        int len = A.length;
        int i = 0;
        int j = len - 1;
        int[] result = new int[len];
        
        for (int k = len - 1; k >= 0; k--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                result[k] = A[i] * A[i];
                i++;
            } else {
                result[k] = A[j] * A[j];
                j--;
            }
        }
        // return squares array
        return result;
    }
}
