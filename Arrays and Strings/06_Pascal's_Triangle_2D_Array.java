// https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1170/
// Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
// In Pascal's triangle, each number is the sum of the two numbers directly above it.

class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        // check for invalid input
        if(numRows == 0)
            return output;
        
        List<Integer> previousRow = new ArrayList<Integer>();
        previousRow.add(1);
        output.add(previousRow);
        
        for(int i = 2; i <= numRows; i++) {
            List<Integer> currentRow = new ArrayList<Integer>();
            //first element in a row
            currentRow.add(1);
            //middle elements in a row
            for(int j = 0; j < previousRow.size() - 1; j++) {
                currentRow.add(previousRow.get(j) + previousRow.get(j+1));
            }
            //last element in a row
            currentRow.add(1);
            
            // add row to output pascal's triangle
            output.add(currentRow);
            previousRow = currentRow;
        }
        
        //return the list containing output pascal's triangle
        return output;  
    }
}
