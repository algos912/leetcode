// https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/1016/
// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/discuss/664580/Java-Concise-recursion

/*
Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 

Follow up:

You may only use constant extra space.
Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
	    return helper(root, 0, new ArrayList<>());
    }

    private Node helper(Node root, int depth, List<Node> nodes) {
	    if (root == null) return null;

	    if (depth < nodes.size()) {
		    nodes.get(depth).next = root;
		    nodes.set(depth, root);
	    } else 
            nodes.add(root);

	    helper(root.left, depth + 1, nodes);
	    helper(root.right, depth + 1, nodes);
	    return root;
    }
}
