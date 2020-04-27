// https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/536/
// Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

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
    public boolean isSymmetric(TreeNode root) {
        //check for invalid inputs
        if(root == null)
            return true;
        
        return isSymmetric(root.left, root.right);    
    }
    
    public boolean isSymmetric(TreeNode l, TreeNode r) {
        if(l == null && r == null)
            return true;
        else if(l == null || r == null)
            return false;
        
        if(l.val != r.val)
            return false;
        
        if(!isSymmetric(l.left, r.right))
            return false;
        if(!isSymmetric(l.right, r.left))
            return false;
        
        return true;
    }
}
