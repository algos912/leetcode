// Number of Islands
// https://leetcode.com/explore/interview/card/facebook/52/trees-and-graphs/274/
/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
*/

// https://leetcode.com/problems/number-of-islands/discuss/56338/Java-DFS-and-BFS-solution

class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                dfsFill(grid,i,j);
                count++;
                }
            }
        }
        return count;
    }
    private void dfsFill(char[][] grid,int i, int j){
        if(i>=0 && j>=0 && i<grid.length && j<grid[0].length&&grid[i][j]=='1'){
            grid[i][j]='0';
            dfsFill(grid, i + 1, j);
            dfsFill(grid, i - 1, j);
            dfsFill(grid, i, j + 1);
            dfsFill(grid, i, j - 1);
        }
    }
}
