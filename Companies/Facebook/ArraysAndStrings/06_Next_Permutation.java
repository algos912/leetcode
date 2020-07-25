// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3012/
// https://leetcode.com/problems/next-permutation/solution/
/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

// https://leetcode.com/problems/next-permutation/discuss/13872/Easiest-JAVA-Solution

class Solution {
    public void nextPermutation(int[] A) {
        
        // check for invalid inputs
        if(A == null || A.length <= 1) 
            return;
    
        int i = A.length - 2;
        
        // Find 1st id i that breaks descending order
        while(i >= 0 && A[i] >= A[i + 1])
            i--;
    
        // If not entirely descending
        if(i >= 0) {
            
            // Start from the end
            int j = A.length - 1;
            
            // Find rightmost first larger id j
            while(A[j] <= A[i]) 
                j--;
            
            // Switch i and j
            swap(A, i, j);
        }
    
        // Reverse the descending sequence
        reverse(A, i + 1, A.length - 1);
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void reverse(int[] A, int i, int j) {
        while(i < j) swap(A, i++, j--);
    }
}
