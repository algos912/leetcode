// https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1228/
// You are given two non-empty linked lists representing two non-negative integers. 
// The digits are stored in reverse order and each of their nodes contain a single digit. 
// Add the two numbers and return it as a linked list.
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        //define a fake head
        ListNode fakeHead = new ListNode(0);
        ListNode p = fakeHead;
        
        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;
        while(p1 != null && p2 != null) {
            // find sum for each index
            int sum = carry;
            if(p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if(p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            
            //set carry
            if(sum > 9){
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }
            
            // assign sum to outputList node
            ListNode output = new ListNode(sum);
            p.next = output;
            p = p.next;
        }
        
        //when one of the lists are empty, just append the other list to merged-list
        while(p1 != null) {
            int sum = carry;
            if(p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            //set carry
            if(sum > 9){
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }
            // assign sum to outputList node
            ListNode output = new ListNode(sum);
            p.next = output;
            p = p.next;
        }
        
        //when one of the lists are empty, just append the other list to merged-list
        while (p2 != null) {
            int sum = carry;
            if(p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            //set carry
            if(sum > 9){
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }
            // assign sum to outputList node
            ListNode output = new ListNode(sum);
            p.next = output;
            p = p.next;
        }
        
        //check the carry value at the end
        if(carry > 0) {
            ListNode output = new ListNode(carry);
            p.next = output;
        }
        
        //return head of new output list
        return fakeHead.next;
    }
}
