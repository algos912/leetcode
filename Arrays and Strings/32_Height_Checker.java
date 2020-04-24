// https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3228/
// Students are asked to stand in non-decreasing order of heights for an annual photo.
// Return the minimum number of students that must move in order for all students to be standing in non-decreasing order of height.

class Solution {
    public int heightChecker(int[] heights) {
        
        //check for invalid inputs
        if(heights == null || heights.length == 0)
            return 0;
        
        //create an ordered height array
        int len = heights.length;
        int[] orderedHeights = new int[len];
        for(int i = 0; i < len; i++) {
            orderedHeights[i] = heights[i];
        }
        Arrays.sort(orderedHeights);
        
        //count number of differences
        int k = 0;
        for(int j = 0; j < len; j++){
            if(orderedHeights[j] != heights[j])
                k++;
        }
        return k;
        
    }
}
