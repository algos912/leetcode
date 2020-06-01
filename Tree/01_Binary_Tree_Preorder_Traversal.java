// https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/928/
// https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/1036/
// Given a binary tree, return the preorder traversal of its nodes' values.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
// ITERATIVE SOLUTION
/*
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        
        // check for invalid inputs
        if(root == null)
            return output;
        
        // add the nodes of tree into a stack
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        //preorder traversal = root, left, right
        while(!stack.empty()){
            TreeNode n = stack.pop();
            output.add(n.val);
            
            if(n.right != null)
                stack.push(n.right);
            
            if(n.left != null)
                stack.push(n.left);
            
        }
        
        // return output list
        return output;
        
    }
}
*/

// RECURSIVE SOLUTION
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        helper(root, output);
        return output;   
    }
    
    public void helper(TreeNode root, List<Integer> output) {
        if(root != null) {
            //root
            output.add(root.val);
            //left
            if(root.left != null)
                helper(root.left, output);
            //right
            if(root.right != null)
                helper(root.right, output);
        }
    }
}
