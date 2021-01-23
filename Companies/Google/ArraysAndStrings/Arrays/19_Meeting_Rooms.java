// Meeting Rooms
/*
Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.

 

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: false
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: true
 

Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti < endi <= 106
*/

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        
        // check for invalid inputs
        if(intervals == null)
            return false;
        
        //sorting
        // TC : O(nlogn)
        // SC : O(1)
        Comparator<int[]> c = (int[] a, int[] b) -> (a[0] - b[0]);
        Arrays.sort(intervals, c);
        for(int i = 0; i < intervals.length-1; i++) {
            
            // look for overlap
            if(intervals[i][1] > intervals[i+1][0])
                return false;
        }
        
        //return true if there is no overlap found
        return true;
        
    }
}
