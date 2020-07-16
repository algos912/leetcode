// https://leetcode.com/explore/learn/card/recursion-ii/507/beyond-recursion/2899/
// https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/solution/

// Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.

// Recursion
// TC : O(n)
// SC : O(n)

class Solution {
  // the smallest (first) and the largest (last) nodes
  Node first = null;
  Node last = null;

  public void helper(Node node) {
    if (node != null) {
      // left
      helper(node.left);
      // node 
      if (last != null) {
        // link the previous node (last)
        // with the current one (node)
        last.right = node;
        node.left = last;
      }
      else {
        // keep the smallest node
        // to close DLL later on
        first = node;
      }
      last = node;
      // right
      helper(node.right);
    }
  }

  public Node treeToDoublyList(Node root) {
    if (root == null) return null;

    helper(root);
    // close DLL
    last.right = first;
    first.left = last;
    return first;
  }
}
