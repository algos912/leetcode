// https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1296/
// Given a linked list, remove the n-th node from the end of list and return its head.

//https://www.programcreek.com/2014/05/leetcode-remove-nth-node-from-end-of-list-java/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        // check for invalid inputs
        if(head == null)
            return null;
 
        // The fast pointer is n steps ahead of the slow pointer. 
        ListNode fast = head;
        ListNode slow = head;
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
 
        // if remove the first node
        if(fast == null){
            head = head.next;
            return head;
        }
 
        // When the fast reaches the end, 
        // the slow pointer points at the previous element of the target element.
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        //skip the target element
        slow.next = slow.next.next;
        return head;
        
    }
}
