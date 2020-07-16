// https://leetcode.com/articles/largest-rectangle-in-histogram/
// https://leetcode.com/explore/learn/card/recursion-ii/507/beyond-recursion/2901/
// Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

class Solution {
    public int largestRectangleArea(int[] heights) {
        
        // SOLUTION 1 : BRUTE FORCE
        // TC : O(n2)
        // SC : O(1)
        int maxarea = 0;
        for (int i = 0; i < heights.length; i++) {
            int minheight = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                minheight = Math.min(minheight, heights[j]);
                maxarea = Math.max(maxarea, minheight * (j - i + 1));
            }
        }
        return maxarea;
        
        // SOLUTION 2 : DIVIDE AND CONQUER
        // TC : O(nlogn)
        // SC : O(n)
        // return calculateArea(heights, 0, heights.length - 1);
        
        // SOLUTION 3 : STACK
        // TC : O(n)
        // SC : O(n)
        /*
        Stack <Integer> stack = new Stack<>();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, 
                               heights[stack.pop()] * (heights.length - stack.peek() -1));
        return maxarea;
        */
        
        
    }
    
    /* This approach relies on the observation that 
        the rectangle with maximum area will be the maximum of:
        
        The widest possible rectangle with height equal to the height of the shortest bar.
        The largest rectangle confined to the left of the shortest bar(subproblem).
        The largest rectangle confined to the right of the shortest bar(subproblem). */
    
    public int calculateArea(int[] heights, int start, int end) {
        if (start > end)
            return 0;
        
        int minheightindex = start;
        for (int i = start; i <= end; i++)
            if (heights[minheightindex] > heights[i])
                minheightindex = i;
        
        return Math.max(heights[minheightindex] * (end - start + 1),
                        Math.max(calculateArea(heights, start, minheightindex - 1), 
                                 calculateArea(heights, minheightindex + 1, end)));
    }
}
