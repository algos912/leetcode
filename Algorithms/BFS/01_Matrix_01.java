// https://leetcode.com/problems/01-matrix
// https://leetcode.com/problems/01-matrix/discuss/639875/Java-Easy-Solution-BFS

// Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
// The distance between two adjacent cells is 1.

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int[][] res = new int[row][col];
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                
                if(matrix[i][j] == 0) {
                    
                    q.add(new Pair(i,j));
                }
            }
        }

        while(!q.isEmpty()) {
            
            Pair<Integer,Integer> p = q.poll();
            int r = p.getKey();
            int c = p.getValue();

            for(int j=0;j<4;j++) {

                int ro = r+dir[j][0];
                int co = c+dir[j][1];

                if(ro<0 || co <0 || ro >= row || co >= col || matrix[ro][co] == 0)
                    continue;

                res[ro][co] = res[r][c]+1;
                matrix[ro][co] = 0;
                q.add(new Pair(ro,co));

            }
        }
        
        return res;
    }
    
}
