// https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1229/
// https://www.programcreek.com/2012/12/leetcode-copy-list-with-random-pointer/

// A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
// Return a deep copy of the list.

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
