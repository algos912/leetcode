// https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/537/
// https://www.programcreek.com/2013/01/leetcode-path-sum/
// Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        // check for invalid inputs
        if(root == null)
            return false;
        
        // true condition
        if (root.val == sum && (root.left == null && root.right == null))
		    return true;
        
        return hasPathSum(root.left, sum - root.val)|| hasPathSum(root.right, sum - root.val);
    }
}
