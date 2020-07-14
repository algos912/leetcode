// https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2872/
// https://www.programcreek.com/2014/04/leetcode-search-a-2d-matrix-ii-java/
/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        // SOLUTION : 1  BRUTE FORCE
        // TC : O(nm)
        // SC : O(1)
        /*
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
        */
        
        // SOLUTION 2 : BINARY SEARCH
        // TC : O(n+m)
        
        // check for invalid inputs
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;
        
        int row = matrix.length-1;
        int col = matrix[0].length-1;
 
        int i = row; 
        int j = 0;
 
        while(i >= 0 && j <= col){
            if(target < matrix[i][j]){
                i--;
            }else if(target > matrix[i][j]){
                j++;
            }else{
                return true;
            }
        }
        return false;
    }
}
