// https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/929/
// Given a binary tree, return the inorder traversal of its nodes' values.
// Follow up: Recursive solution is trivial, could you do it iteratively?

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
        
        // check for invalid inputs
        if(root == null)
            return output;
        
        //put nodes of tree into a stack
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while(p!= null){
            stack.push(p);
            p = p.left;
        }
        
        //inoder traversal : left, root, right
        while(!stack.empty()){
            TreeNode t = stack.pop();
            output.add(t.val);
            
            t = t.right;
            while(t != null) {
                stack.push(t);
                t = t.left;
            }
            
        }
        
        // return the output list
        return output;
        
    }
}
