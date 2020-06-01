// https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/994/

/*
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

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
 

Example 1:



Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 

Constraints:

The number of nodes in the given tree is less than 4096.
-1000 <= node.val <= 1000
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
        // cur is parent level node
        Node cur = root, sentinal = new Node(0);
        // p is child level node, sentinal acts as head node
        Node p;
        // check if have next level
        while (cur != null) {
            p = sentinal;
            // check if heve next parent node
            while (cur != null) {
                // add left child after p
                if (cur.left != null) {
                    p = p.next = cur.left;
                }
                // add right child after p
                if (cur.right != null) {
                    p = p.next = cur.right;
                }
                cur = cur.next;
            }
            cur = sentinal.next;
            sentinal.next = null;
        }
        return root;
        
    }
}
