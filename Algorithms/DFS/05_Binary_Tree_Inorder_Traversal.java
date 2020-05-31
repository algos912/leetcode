// https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1383/
// Given a binary tree, return the inorder traversal of its nodes' values.

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        helper(root, output);
        return output;   
    }
    
    public void helper(TreeNode root, List<Integer> output) {
        if(root != null) {
            if(root.left != null)
                helper(root.left, output);
            output.add(root.val);
            if(root.right != null)
                helper(root.right, output);
        }
    }
}
