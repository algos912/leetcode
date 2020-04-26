// https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1209/
// https://www.programcreek.com/2014/07/leetcode-palindrome-linked-list-java/
// Given a singly linked list, determine if it is a palindrome.
// Follow up: Could you do it in O(n) time and O(1) space?

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        // check for invalid inputs
        if(head == null)
            return true;
        
        // Solution 1: create a new list in reversed order and compare
        // TC: O(n), SC: O(n)
        ListNode curr = head;
        ListNode prev = new ListNode(head.val);
        while(curr.next != null) {
            ListNode temp = new ListNode(curr.next.val);
            temp.next = prev;
            
            prev = temp;
            curr = curr.next;
        }
        
        //compare
        ListNode p1 = head;
        ListNode p2 = prev;
        while(p1 != null){
            if(p1.val != p2.val)
                return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
        
    }
}
