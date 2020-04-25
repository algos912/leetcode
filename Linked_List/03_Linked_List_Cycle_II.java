// https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1214/
// Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            
            // cycle exists
            if(fast == slow)
                break;
        }
        
        // no cycle
        if(fast == null || fast.next == null)
            return null;

        // cycle exists
        if(fast == slow){
            slow = head; //slow back to start point
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow; //cycle begins at fast == slow
        
    }
}
