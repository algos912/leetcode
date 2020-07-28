// Copy List with Random Pointer
// https://leetcode.com/explore/interview/card/facebook/6/linked-list/3020/
/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
*/

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        // check for invalid inputs
        if(head == null)
            return head;
        
        Node p = head;
        
        // copy every node and insert it to the list
        while (p != null) {
            Node copy = new Node(p.val);
            copy.next = p.next;
            p.next = copy;
            p = copy.next;
        }
        
        // copy random pointer for each new node
        p = head;
        while(p != null) {
            if(p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        
        // break list to two
        p = head;
        Node newHead = head.next;
        while(p != null) {
            Node temp = p.next;
		    p.next = temp.next;
		    if (temp.next != null)
			    temp.next = temp.next.next;
		    p = p.next;
        }
        
        return newHead;
        
    }
}
