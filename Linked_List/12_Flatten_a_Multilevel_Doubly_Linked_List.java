// https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1225/
// https://www.cnblogs.com/Dylan-Java-NYC/p/9596026.html
/*
You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.

Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        
        // check for invalid inputs
        if(head == null)
            return head;
        
        //TC : O(n), SC: O(1)
        Node cur = head;
        while(cur != null) {
            if(cur.child == null){
                cur = cur.next;
                continue;
            } else {
                Node child = cur.child;
                Node childTail = child;
                while(childTail.next != null) {
                    childTail = childTail.next;
                }
                
                cur.child = null;
                child.prev = cur;
                childTail.next = cur.next;
                if(cur.next != null) {
                    cur.next.prev = childTail;
                }
                cur.next = child;
                cur = cur.next;
            }
        }
        return head;
        
    }
}
