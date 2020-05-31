// https://leetcode.com/problems/daily-temperatures/

// TC : O(N)
// SC : O(size of stack)

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] output = new int[T.length];
        Stack<Integer> stack = new Stack();
        
        for(int i = T.length-1; i >= 0; i--) {
            while(!stack.isEmpty() && T[i] >= T[stack.peek()])
                stack.pop();
            output[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return output;
    }
}
