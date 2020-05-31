// https://leetcode.com/problems/walls-and-gates/
// https://www.youtube.com/watch?v=Pj9378ZsCh4

/*
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

Example: 

Given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
  */
  
  class Solution {
    public void wallsAndGates(int[][] rooms) {
        
        // check for invalid inputs
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0) 
            return;
        
        int m = rooms.length;
        int n = rooms[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(rooms[i][j] == 0)
                    dfs(i, j, 0, rooms);
            }
        }
    }
    
    public void dfs(int i, int j, int count, int[][] rooms) {
        //invalid cases
        if(i < 0 || i >= rooms.length || j < 0 || j >= rooms[i].length || rooms[i][j] < count)
            return;
        
        // store the distance count, in the cell of the room
        rooms[i][j] = count;
        
        // traverse the neighboring cells of the current cell
        dfs(i+1, j, count+1, rooms);
        dfs(i-1, j, count+1, rooms);
        dfs(i, j+1, count+1, rooms);
        dfs(i, j-1, count+1, rooms);
        
        
    }
}
