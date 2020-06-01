// https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/942/
// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/discuss/664602/java-neat-solution.

/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (null == inorder || null == postorder) {
			return null;
		}
		return buildTree(inorder, 0, inorder.length - 1, postorder,  0, postorder.length - 1);  
    }
    
    public TreeNode buildTree(int[] inorder, int inL, int inR,
							  int[] postorder, int postL, int postR) {
		if (inL > inR) {
			return null;
		}
		if (inL == inR) {
		  return new TreeNode(inorder[inL]);
		}

		TreeNode node = new TreeNode(postorder[postR]);
		int idx = inL;  
		for (int i = inL; i <= inR; i++) {
			if (inorder[i] == postorder[postR]) {
				idx = i;
				break;
			}
		}
		node.left = buildTree(inorder, inL, idx - 1, postorder, postL, postL + (idx - 1 - inL));
		node.right = buildTree(inorder, idx + 1, inR, postorder, postL + (idx - 1 - inL) + 1, postR - 1);
		return node;
	}
}
