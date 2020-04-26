// https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1227/
// https://www.programcreek.com/2012/12/leetcode-merge-two-sorted-lists-java/
// Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        //define a new fake head
        ListNode head = new ListNode(0);
        ListNode p = head;
        
        //compare first elements from each list and add smaller one to merged list
        ListNode p1 = l1;
        ListNode p2 = l2;
        while(p1 != null && p2 != null) {
            if(p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        
        //when one of the lists are empty, just append the other list to merged-list
        if(p1 != null) {
            p.next = p1;
        }
        
        if(p2 != null) {
            p.next = p2;
        }
        
        //return head of merged list
        return head.next;
        
    }
}
