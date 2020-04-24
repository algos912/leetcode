// https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3260/
// Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
// You may return any answer array that satisfies this condition.

class Solution {
    public int[] sortArrayByParity(int[] A) {
        
        // check for invalid inputs
        if(A == null || A.length == 0)
            return new int[] {};
        
        //check for even and swap it to first element
        // TC : O(n2), SC: O(1)
        int tmp = 0;
        for(int i = 0; i < A.length; i++) {
            for(int j = i+1; j < A.length; j++) {
                if (A[j] % 2 == 0){
                    tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;
                }
            }
        }
        return A;
        
    }
}
