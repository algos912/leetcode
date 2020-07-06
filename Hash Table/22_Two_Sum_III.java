// https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1179/
// Two Sum III - Data structure design
/*
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

Example 1:

add(1); add(3); add(5);
find(4) -> true
find(7) -> false
Example 2:

add(3); add(1); add(2);
find(3) -> true
find(6) -> false
*/

class TwoSum {
    private HashMap<Integer,Integer> numCount;

    /** Initialize your data structure here. */
    public TwoSum() {
        this.numCount = new HashMap<Integer,Integer>();  
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(numCount.containsKey(number))
            numCount.replace(number, numCount.get(number)+1);
        else
            numCount.put(number, 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(Map.Entry<Integer,Integer> entry: numCount.entrySet()) {
            int complement = value - entry.getKey();
            
            if(complement != entry.getKey()) {
                if(numCount.containsKey(complement))
                    return true;
            } else {
                if(entry.getValue() > 1)
                    return true;
            }
            
        }
        // didnt find any matching value
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
