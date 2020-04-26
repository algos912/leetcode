// https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1295/
// http://www.lifeincode.net/programming/leetcode-rotate-list-java/
// Given a linked list, rotate the list to the right by k places, where k is non-negative.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // check for invalid input
        if (head == null || k == 0)
            return head;
        
        // two pointer
        // TC : O(n+k)
        ListNode slow = head;
        ListNode fast = head;
        while (k > 0) {
            k--;
            fast = fast.next;
            if (fast == null)
                fast = head;
        }
        // length of list <= k
        if (fast == null || slow == fast)
            return head;
        
        // connect fast or last node to existing head
        // slow.next is the new head
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        
        return newHead;
        
    }
}
