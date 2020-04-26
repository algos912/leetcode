// https://leetcode.com/problems/insert-into-a-cyclic-sorted-list/
// https://www.cnblogs.com/Dylan-Java-NYC/p/10972122.html
// Given a node from a cyclic linked list which is sorted in ascending order, write a function to insert a value into the list such that it remains a cyclic sorted list. The given node can be a reference to any single node in the list, and may not be necessarily the smallest value in the cyclic list.

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}
    public Node(int val,Node next) {
      this.val = val;
      this.next = next;
    }
};
*/

class Solution {
    public Node inesrt(Node head, int insertVal) {
        // if list is empty
         if(head == null) {
            head = new Node(insertVal, null);
            head.next = head;
            break;
        }
      
        //find the place for insertVal, in sortedlist
        Node cur = head;
        while(cur.next != null) {
            if(cur.val < cur.next.val) {
                if(cur.val<=insertVal && insertVal<=cur.next.val){
                     cur.next = new Node(insertVal, cur.next);
                     break;
                 }
            } else if (cur.val > cur.next.val) {
                if(cur.val<=insertVal && insertVal<=cur.next.val){
                     cur.next = new Node(insertVal, cur.next);
                     break;
                 }
            } else {
                if(cur.next == head) {
                    cur.next == new Node(inserVal, head);
                    break;
                }
            }
            cur = cur.next;
        }
        
        //return head of list
        return head;
    }
}
