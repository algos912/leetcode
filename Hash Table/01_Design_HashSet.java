// https://leetcode.com/explore/learn/card/hash-table/182/practical-applications/1139/
// http://www.programmersought.com/article/116770437/

/*
Design a HashSet without using any built-in hash table libraries.

To be specific, your design should include these functions:
add(value): Insert a value into the HashSet. 
contains(value) : Return whether the value exists in the HashSet or not.
remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.

Example:

MyHashSet hashSet = new MyHashSet();
hashSet.add(1);         
hashSet.add(2);         
hashSet.contains(1);    // returns true
hashSet.contains(3);    // returns false (not found)
hashSet.add(2);          
hashSet.contains(2);    // returns true
hashSet.remove(2);          
hashSet.contains(2);    // returns false (already removed)
*/

class MyHashSet {
    boolean[] map;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        map = new boolean[1000005];
    }
    
    public void add(int key) {
        map[key] = true;
    }
    
    public void remove(int key) {
        map[key] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return map[key] == true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
