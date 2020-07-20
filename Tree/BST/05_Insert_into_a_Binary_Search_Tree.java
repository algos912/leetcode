// https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/141/basic-operations-in-a-bst/1003/
/*
Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
    
        // TC : O(h), that is O(N) in worst case and O(logn) in ideal case
        // SC: O(h), that is O(N) in worst case and O(logn) in ideal case
        
        if (root == null) {
            return new TreeNode(val);   // return a new node if root is null
        }
        
        if (root.val < val) {           // insert to the right subtree if val > root->val
            root.right = insertIntoBST(root.right, val);
        } else {                        // insert to the left subtree if val <= root->val
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
