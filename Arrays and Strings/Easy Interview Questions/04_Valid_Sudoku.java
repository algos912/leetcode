// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/769/
/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
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
