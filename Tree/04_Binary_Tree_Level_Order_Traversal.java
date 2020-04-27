// https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/931/
// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//IREATIVE SOLUTION
/*
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> output = new ArrayList<>();
        // check for invalid inputs
		if (root == null)
			return output;
	    
        // use a queue to keep track of the level
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			ArrayList<Integer> level = new ArrayList<Integer>(size);

			for (int i = 0; i < size ; i++) {
				TreeNode n = queue.remove();
				level.add(n.val);

				if (n.left != null)
					queue.add(n.left);
				if (n.right != null)
					queue.add(n.right);
			}
			
			output.add(level);
		}
        
        // return output list
		return output;
	}
}
*/

//RECURSIVE SOLUTION
class Solution {
    List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        // check for invalid inputs
		if (root == null)
			return output;
	    
        // use a helper function
        helper(root, 0);
        
        // return output list
		return output;
	}
    
    public void helper(TreeNode root, int level) {
        if(level == output.size())
            output.add(new ArrayList<Integer>());
        
        //root
        output.get(level).add(root.val);
        //child left
        if(root.left != null)
            helper(root.left, level+1);
        //child right
        if(root.right != null)
            helper(root.right, level+1);
    }
}
