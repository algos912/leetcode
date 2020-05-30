// https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1373/
// https://www.programcreek.com/2014/05/leetcode-walls-and-gates-java/

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
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(rooms[i][j] == 0)
                    queue.offer(i*n + j);
            }
        }
        
        while(!queue.isEmpty()) {
            int head = queue.poll();
            int x = head / n;
            int y = head % n;
            
            if(x > 0 && rooms[x-1][y] == Integer.MAX_VALUE) {
                rooms[x-1][y] = rooms[x][y] + 1;
                queue.offer((x-1)*n+y);
            }
            if(x < m-1 && rooms[x+1][y] == Integer.MAX_VALUE) {
                rooms[x+1][y] = rooms[x][y] + 1;
                queue.offer((x+1)*n+y);
            }
            if(y > 0 && rooms[x][y-1] == Integer.MAX_VALUE) {
                rooms[x][y-1] = rooms[x][y] + 1;
                queue.offer(x*n+(y-1));
            }
            if(y < n-1 && rooms[x][y+1] == Integer.MAX_VALUE) {
                rooms[x][y+1] = rooms[x][y] + 1;
                queue.offer(x*n+(y+1));
            }
        }
        
    }
}

