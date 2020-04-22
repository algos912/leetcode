// https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1167/
// Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.

/* Example:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

Output:  [1,2,4,7,5,3,6,8,9]

Note:

The total number of elements of the given matrix will not exceed 10,000.
*/

class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{};
        }
        
        int numOfRows = matrix.length;
        int numOfCols = matrix[0].length;
        int product = numOfRows * numOfCols;
        int[] output = new int[product];
        
        int dir = 0;
        int x = 0;
        int y = 0;
        
        for(int i = 0; i < product; i++){
            output[i] = matrix[x][y];
            
            // x+y is even, then traversal line goes up
            // x+y is odd, then traversal line goes down
            
            // if (x+y) is EVEN, then go up
            if ((x + y) % 2 == 0) {
                // If last column then go to next row
                if (y == numOfCols - 1) {
                    x++;
                }
                // If first row but not last column then go to next column
                else if (x == 0) {
                    y++;
                }
                // Go up
                else {
                    x--;
                    y++;
                }
            }
            
            // if (x+y) is ODD, then go down
            else {
                // If last row then go to next column
                if (x == numOfRows - 1) {
                    y++;
                }
                // If first column but not last row then go to next row
                else if (y == 0) {
                    x++;
                }
                // Go down
                else {
                    x++;
                    y--;
                }
            }
            
        }
        return output;
        
    }
}
