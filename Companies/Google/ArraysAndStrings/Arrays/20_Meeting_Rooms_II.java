// Meeting Rooms II
/*
Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

 

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1
 

Constraints:

1 <= intervals.length <= 104
0 <= starti < endi <= 106
*/

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        // check invalid inputs
        if( intervals == null || intervals.length == 0)
            return 0;
        
        // the minimal number of rooms equal to the max number of overlapping meeting in any time point. 
        // The code is actually counting the number of overlapping meetings 
        // throughout the timeline and recording the maximum.
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int endsItr = 0;
        for(int i=0; i < starts.length; i++) {
            if(starts[i] < ends[endsItr])
                rooms++;
            else
                endsItr++;
        }
        return rooms;
        
    }
}
