// https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1371/
// https://leetcode.com/problems/perfect-squares/discuss/165688/BFS-and-DP
// Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

class Solution {
    public int numSquares(int n) {
        
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        int count = 0;
        
        // add first element to queue
        queue.add(0);
        visited.add(0);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                int curr = queue.poll();
                
                if(curr > n)
                    continue;
                if(curr == n)
                    return count;
                
                for (int i = 1; curr + i * i <= n; i++) {
                    if (visited.contains(curr + i * i)) {
                        continue;
                    }
                    queue.add(curr + i * i);
                    visited.add(curr + i * i);
                }
                
                //decrement size
                size--;
            }
                
            // increment count
            count++;
        }
        
        return -1;
    }
}

/*
public int numSquares01(int n) {

        int[] state = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            state[i] = i;
            for (int j = 1; j <= i; j++) {
                if (j * j > i) {
                    break;
                }
                state[i] = Math.min(state[i - j * j] + 1, state[i]);
            }
        }

        return state[n];
  }
    
*/
