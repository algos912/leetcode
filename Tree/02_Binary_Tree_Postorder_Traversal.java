// https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/930/
// Given a binary tree, return the postorder traversal of its nodes' values.
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        
        // check for invalid inputs
        if(root == null) {
            return output;
        }
        
        // push all nodes into a stack
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        // postorder traversal = left, right, root
        TreeNode prev = null;
        while(!stack.empty()) {
            TreeNode curr = stack.peek();
            
            // go down the tree.
            //check if current node is leaf, if so, process it and pop stack,
            //otherwise, keep going down
            if(prev == null || prev.left == curr || prev.right == curr){
                //prev == null is the situation for the root node
                if(curr.left != null){
                    stack.push(curr.left);
                }else if(curr.right != null){
                    stack.push(curr.right);
                }else{
                    stack.pop();
                    output.add(curr.val);
                }
 
            //go up the tree from left node    
            //need to check if there is a right child
            //if yes, push it to stack
            //otherwise, process parent and pop stack
            }else if(curr.left == prev){
                if(curr.right != null){
                    stack.push(curr.right);
                }else{
                    stack.pop();
                    output.add(curr.val);
                }
 
            //go up the tree from right node 
            //after coming back from right node, process parent node and pop stack. 
            }else if(curr.right == prev){
                stack.pop();
                output.add(curr.val);
            }
 
            prev = curr;
            
        }
        
        // return the output list
        return output;
        
    }
}
