// https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1215/
// Write a program to find the node at which the intersection of two singly linked lists begins.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// Solution 1 - WRONG ANSWER (Program Creek)
/*
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        //check for invalid inputs
        if(headA == null || headB == null)
            return null;
        
        //find lengths of two lists
        int len1 = 0;
        int len2 = 0;
        ListNode p1 = headA;
        ListNode p2 = headB;
        
        while(p1 != null) {
            len1++;
            p1 = p1.next;
        }
        
        while(p2 != null) {
            len2++;
            p2 = p2.next;
        }
        
        // find the difference in lengths
        // Then start from the longer list at the diff offset, iterate though 2 lists and find the node.
        int diff = 0;
        p1 = headA;
        p2 = headB;
        if(len1 > len2) {
            diff = len1 - len2;
            int i = 0;
            while (i < diff){
                i++;
                p1 = p1.next;
            }
        } else {
            diff = len2 - len1;
            int i = 0;
            while(i < diff){
                i++;
                p2 = p2.next;
            }
        }
        
        // return the intersection node
        while(p1 != null && p2 != null) {
            if(p1.val == p2.val)
                return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        
        //no intersection
        return null;
        
    }
}
*/

//Solution 2: two pointer
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;  
        
        ListNode curA=headA;  
        ListNode curB=headB;  
        int count=0;  
        
        while(count<2 && curA!=curB){  
            curA=curA.next;  
            curB=curB.next;  
            if(curA==null){  
                curA=headB;  
                count++;  
            }  
            if(curB==null) curB=headA;  
        }  
        if(curA==curB) return curA;  
        return null;  
        
    }
}
