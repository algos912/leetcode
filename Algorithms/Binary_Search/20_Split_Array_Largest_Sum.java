// https://leetcode.com/explore/learn/card/binary-search/146/more-practices-ii/1042/
// https://leetcode.com/problems/split-array-largest-sum/discuss/89817/Clear-Explanation%3A-8ms-Binary-Search-Java
/*
Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.

Note:
If n is the length of array, assume the following constraints are satisfied:

1 ≤ n ≤ 1000
1 ≤ m ≤ min(50, n)
*/

// TC : nlog(n)
// SC : O(1)

class Solution {
    public int splitArray(int[] nums, int m) {
        
        /*
        Given a result, it is easy to test whether it is valid or not.
        The max of the result is the sum of the input nums.
        The min of the result is the max num of the input nums.
        */
        int sum = 0;
        int maxNum = 0;
        for(int i : nums) {
            sum += i;
            maxNum = Math.max(maxNum, i);
        }
        
        // edge case
        if(m == 1) return sum;
        
        // binary search
        long low = maxNum;
        long high = sum;
        long mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            
            if(valid(mid, nums, m)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        // return high value
        return (int) low;
        
    }
    
    public boolean valid(long target, int[] nums, int m) {
        int count = 1;
        long total = 0;
        for(int num : nums) {
            total += num;
            if (total > target) {
                total = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}
