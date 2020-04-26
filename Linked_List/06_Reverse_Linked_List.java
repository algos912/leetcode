// https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1205/
// Reverse a singly linked list.
// Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
// https://www.programcreek.com/2014/05/leetcode-reverse-linked-list-java/
 
class Solution {
    public ListNode reverseList(ListNode head) {
        
        // corner case
        if(head == null || head.next == null)
            return head;
        
        // 1. Iterative solution
        ListNode p1 = head;
        ListNode p2 = p1.next;
        
        //convert head as tail
        head.next = null;
        
        while(p1 != null && p2 != null) {
            ListNode t = p2.next;
            p2.next = p1; //swap direction of each node
            
            p1 = p2;
            p2 = t;
        }
        
        // return new head
        return p1;
        
        /*
        // 2. Recursive solution
        // get second node
        ListNode second = head.next;
        // set first node's next to be null (convert head as tail)
        head.next = null;
        
        ListNode rest = reverseList(second);
        second.next = head;
        
        return rest;
        */
    }
}
