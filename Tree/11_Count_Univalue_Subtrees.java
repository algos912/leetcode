// https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/538/
// https://cheonhyangzhang.wordpress.com/2017/01/08/250-leetcode-java-count-univalue-subtrees-medium/

/*
Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

Example :

Input:  root = [5,1,5,5,5,null,5]

              5
             / \
            1   5
           / \   \
          5   5   5

Output: 4
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        
        // check for in valid inputs
        if(root == null)
            return 0;
        
        isUni(root);
        return count;   
    }
    
    public boolean isUni(TreeNode node) {
        if(node == null)
            return true;
        
        boolean left = isUni(node.left);
        boolean right = isUni(node.right);
        
        if(left == true && right == true) {
            if(node.left != null && node.left.val != node.val)
                return false;
            if(node.right != null && node.right.val != node.val)
                return false;
            count++;
            return true;
        } else {
            return false;
        }
        
    }
}
