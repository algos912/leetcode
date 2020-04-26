// https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1207/
// https://www.programcreek.com/2014/04/leetcode-remove-linked-list-elements-java/
// Remove all elements from a linked list of integers that have value val.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // The key to solve this problem is using a helper node to track the head of the list.
        ListNode helper = new ListNode(0);
        helper.next = head;
        
        ListNode curr = helper;
        while(curr.next != null){
            // if next node has value val, skip it
            if(curr.next.val == val) {
                //ListNode tmp = curr.next;
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        
        //return head position
        return helper.next;
        
    }
}
