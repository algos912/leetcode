// Shortest Distance from All Buildings
// https://leetcode.com/explore/interview/card/facebook/52/trees-and-graphs/3026/
// https://leetcode.com/problems/shortest-distance-from-all-buildings/discuss/76891/Java-solution-with-explanation-and-time-complexity-analysis
/*
You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.
Example:

Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]

1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0

Output: 7 

Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
             the point (1,2) is an ideal empty land to build a house, as the total 
             travel distance of 3+3+1=7 is minimal. So return 7.
Note:
There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
*/

class Solution {
    /**
 * Step 1: start from every point 1 (building point), doing BFS traversal to fill out (or accumulate) distance array
 * (MUST start over and doing every BFS traversal individually)
 * 
 * Step 2: find minimum distance from dp array
 * 
 * @param dp: store distance sum to all building for every point 0. Update values when we do BFS traversal
 * @param reach: store number of buildings that every point 0 can reach. Used for checking if current point is valid
 *             while we want to find final result
 * @param countBuilding: count total number of point 1
 * */
final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
public int shortestDistance(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int[][] dp = new int[n][m];
    int[][] reach = new int[n][m];
    int countBuilding = 0;
    Queue<int[]> queue = new LinkedList<>();

    // step 1
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (grid[i][j] == 1) {
                queue.offer(new int[]{i, j});
                bfs(queue, grid, dp, reach, n, m);
                countBuilding++;
            }
        }
    }

    // step 2
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            // WARNING: DO NOT FORGET to check whether current point is 0 and whether current point can reach all buildings
            if (grid[i][j] == 0 && reach[i][j] == countBuilding) {
                result = Math.min(result, dp[i][j]);
            }
        }
    }
    return result == Integer.MAX_VALUE ? -1 : result;
}

public void bfs(Queue<int[]> queue, int[][] grid, int[][] dp, int[][] reach, int n, int m) {
    int level = 1;
    // DO NOT USE hashset, since hashset cannot determine whether it contains an array (coordinate)
    boolean[][] visited = new boolean[n][m];
    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int[] curPoint = queue.poll();
            int x = curPoint[0];
            int y = curPoint[1];
            for (int j = 0; j < 4; j++) {
                int dx = x + dir[j][0];
                int dy = y + dir[j][1];
                if (dx < 0 || dx > n - 1 || dy < 0 || dy > m - 1 || grid[dx][dy] != 0 || visited[dx][dy]) {
                    continue;
                }
                queue.offer(new int[]{dx, dy});
                visited[dx][dy] = true;
                dp[dx][dy] += level;
                reach[dx][dy]++;
            }
        }
        level++;
    }
}
}
