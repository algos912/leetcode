// https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1171/
// Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
// Note that the row index starts from 0.

// In Pascal's triangle, each number is the sum of the two numbers directly above it.

class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        List<Integer> previousRow = new ArrayList<Integer>();
        previousRow.add(1);
        
        //return first row
        if(rowIndex == 0)
            return previousRow;
        
        for(int i = 1; i <= rowIndex; i++) {
            List<Integer> currentRow = new ArrayList<Integer>();
            
            //first element in the row
            currentRow.add(1);
            
            //middle elements in the row
            for(int j = 0; j < previousRow.size() - 1; j++) {
                currentRow.add(previousRow.get(j) + previousRow.get(j+1));
            }
            
            //last element in the row
            currentRow.add(1);
            
            previousRow = currentRow;
        }
        
        // return last row
        return previousRow;
        
        /*
        // Follow Up: Could you optimize your algorithm to use only O(k) extra space?
        
        List<Integer> result = new ArrayList<Integer>();
        long c = 1;
        for (int j = 0; j <= rowIndex; j++) {
            result.add((int) c);
            c *= rowIndex - j;
            c /= j + 1;
        }
        return result;
        */
        
    }
}
