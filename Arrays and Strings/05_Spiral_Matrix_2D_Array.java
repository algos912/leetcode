// https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1168/
// Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

/*
Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
*/

// We go boundary by boundary and move inwards. That is the essential operation. 
// First row, last column, last row, first column and then we move inwards by 1 and then repeat.

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> output = new ArrayList<Integer>();
        if(matrix.length == 0 || matrix[0].length == 0)
            return output;
        
        if(matrix.length == 1){
            for(int i = 0; i < matrix[0].length; i++){
                output.add(matrix[0][i]);
            }
            return output;
        } else if (matrix[0].length == 1){
            for(int i = 0; i < matrix.length; i++){
                output.add(matrix[i][0]);
            }
            return output;
        }
        
        int x = 0;
        int y = 0;
        int numOfRows = matrix.length;
        int numOfCols = matrix[0].length;
        int product = numOfRows * numOfCols;
        int dir = 1;
        
        int roundNum = 0;
        int startRoundX = roundNum;
        int startRoundY = roundNum;
        int endRoundX = numOfRows - 1 - roundNum;
        int endRoundY = numOfCols - 1 - roundNum;
        
        for(int i = 0; i < product; i++) {
            output.add(matrix[x][y]);
            
            if (dir == 1) {
                y++;
                if(y == endRoundY)
                    dir = 2;
            } else if (dir == 2) {
                x++;
                if(x == endRoundX)
                    dir = 3;
            } else if (dir == 3) {
                y--;
                if(y == startRoundY)
                    dir = 4;
            } else if (dir == 4) {
                x--;
                if(x == startRoundX + 1) {
                    dir = 1;
                    roundNum++;
                    
                    startRoundX = roundNum;
                    startRoundY = roundNum;
                    endRoundX = numOfRows - 1 - roundNum;
                    endRoundY = numOfCols - 1 - roundNum;
                }
            }
            
            
        }
        return output;
        
    }
}
