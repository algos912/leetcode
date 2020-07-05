// https://leetcode.com/explore/learn/card/hash-table/185/hash_table_design_the_key/1126/
// https://leetcode.com/problems/valid-sudoku/solution/
// https://www.programcreek.com/2014/05/leetcode-valid-sudoku-java/

/*
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Example 1:

Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true
Example 2:

Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being 
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
The given board contain only digits 1-9 and the character '.'.
The given board size is always 9x9.
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        // check for invalid input
        if(board == null || board.length != 9 || board[0].length != 9)
            return false;
        
        // check each column
        for(int row = 0; row < 9; row++) {
            boolean[] m = new boolean[9];
            for(int col = 0; col < 9; col++) {
                if(board[row][col] != '.') {
                    int index = (int) (board[row][col] - '1');
                    if(m[index] == true) return false;
                    m[index] = true;
                }
            }
        }
        
        // check each row
        for(int col = 0; col < 9; col++) {
            boolean[] m = new boolean[9];
            for(int row = 0; row < 9; row++) {
                if(board[row][col] != '.') {
                    int index = (int) (board[row][col] - '1');
                    if(m[index] == true) return false;
                    m[index] = true;
                }
            }
        }
        
        // check each 3*3 matrix
        for(int block = 0; block < 9; block++) {
            boolean[] m = new boolean[9];
            for (int row = block / 3 * 3; row < block / 3 * 3 + 3; row++) {
                for (int col = block % 3 * 3; col < block % 3 * 3 + 3; col++) {
                    if(board[row][col] != '.') {
                        int index = (int) (board[row][col] - '1');
                        if(m[index] == true) return false;
                        m[index] = true;
                    }
                }
            }
        }
        
        // return valid
        return true; 
    }
}
