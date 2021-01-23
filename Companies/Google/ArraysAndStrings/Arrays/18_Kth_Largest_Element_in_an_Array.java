// Kth Largest Element in an Array
/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        // check for invalid inputs
        if(nums == null || nums.length == 0)
            return 0;
        
        // solution 1 : sorting
        // TC : O(N log N)
        // SC : O(1)
        // Arrays.sort(nums);
        // return nums[nums.length - k];
        
        // Solution 2 : heap
        // TC: adding an element in a heap of size k is O(logk) and we do it N times that means O(Nlogk)
        // SC : O(k)
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1,n2) -> n1 - n2);
        
        // keep k largest element in the heap
        for(int n : nums) {
            heap.add(n);
            if(heap.size() > k)
                heap.poll();
        }
        
        //output
        return heap.poll();
        
        
    }
}
