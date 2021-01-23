// Trapping Rain Water
/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
0 <= n <= 3 * 104
0 <= height[i] <= 105
*/

// https://leetcode.com/problems/trapping-rain-water/discuss/17391/Share-my-short-solution.
// TC : O(N)
// SC : O(1)
// two pointers

class Solution {
    public int trap(int[] height) {
        
        // check invalid inputs
        if(height == null || height.length == 0)
            return 0;
        
        int area = 0;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        while(left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            
            // how much can current position trap depends on the shorter bar
            if(leftMax < rightMax) {
                // area = leftMax - currentheight
                area += leftMax - height[left];
                left++;
                
            } else {
                // area = rightMax - currentheight
                area += rightMax - height[right];
                right--;
            }
            
        }
        
        // return amount of water trapped
        return area;
        
    }
}
