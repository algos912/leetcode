// https://leetcode.com/explore/learn/card/linked-list/209/singly-linked-list/1290/
// Design your implementation of the linked list. You can choose to use the singly linked list or the doubly linked list.

/*
Design your implementation of the linked list. You can choose to use the singly linked list or the doubly linked list. A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node. If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement these functions in your linked list class:

get(index) : Get the value of the index-th node in the linked list. If the index is invalid, return -1.
addAtHead(val) : Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
addAtTail(val) : Append a node of value val to the last element of the linked list.
addAtIndex(index, val) : Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
deleteAtIndex(index) : Delete the index-th node in the linked list, if the index is valid.
*/

class MyLinkedList {

    /** Initialize your data structure here. */
    Node head;
    Node tail;
    int size;
    public MyLinkedList() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        
        Node curr = head.next;
        int idx = 0;
        while (idx < index) {
            idx++;
            curr = curr.next;
        }
        return curr.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head.next;
        newNode.prev = head;
        
        head.next.prev = newNode;
        head.next = newNode;
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        newNode.prev = tail.prev;
        newNode.next = tail;
        
        tail.prev.next = newNode;
        tail.prev = newNode;
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
        }
        else if (index == size) {
            addAtTail(val);
        }
        else {
            int idx = 0;
            Node curr = head;
            while (idx < index) {
                idx++;
                curr = curr.next;
            }
            
            Node newNode = new Node(val);
            newNode.prev = curr;
            newNode.next = curr.next;
            
            curr.next.prev = newNode;
            curr.next = newNode;
            size++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        
        int idx = 0;
        Node curr = head;
        while (idx < index) {
            idx++;
            curr = curr.next;
        }
        
        Node next = curr.next.next;
        next.prev = curr;
        
        curr.next = next;
        size--;
    }
}

class Node {
    int val;
    Node next;
    Node prev;
    
    public Node(int val) {
        this.val = val;
        next = null;
        prev = null;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
