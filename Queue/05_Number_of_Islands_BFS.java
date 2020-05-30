// https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1374/
// https://leetcode.com/problems/number-of-islands/discuss/56338/Java-DFS-and-BFS-solution
// Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
/*
Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
*/

TC : O(m*n)
SC : O(n)

class Solution {
    public int numIslands(char[][] grid) {
        
        // check for invalid inputs
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int count=0;
        for(int i=0;i < grid.length;i++) {
            for(int j=0;j < grid[0].length;j++){
                if(grid[i][j]=='1'){
                    bfsFill(grid,i,j);
                    count++;
                }
            }
        }
        
        // return the count of islands
        return count;
    }
    
    public void bfsFill(char[][] grid,int p,int q) {
        grid[p][q] = '0';
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(p*n+q);
        
        while(!queue.isEmpty()) {
            int head = queue.poll(); // take first element in queue
            int x = head / n;
            int y = head % n;
            
            // search upward and mark adjacent '1's as '0'.
            if(x > 0 && grid[x-1][y] == '1') {
                grid[x-1][y] = '0';
                queue.offer((x-1)*n + y);
            }
            
            // down
            if(x < m-1 && grid[x+1][y] == '1') {
                grid[x+1][y] = '0';
                queue.offer((x+1)*n + y);
            }
            
            // left
            if(y > 0 && grid[x][y-1] == '1') {
                grid[x][y-1] = '0';
                queue.offer(x*n + (y-1));
            }
            
            // right
            if(y < n-1 && grid[x][y+1] == '1') {
                grid[x][y+1] = '0';
                queue.offer(x*n + (y+1));
            }
            
        }
    }
}
