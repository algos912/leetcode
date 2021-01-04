// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/549/
/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?

 

Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1
 

Constraints:

1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.
*/

class Solution {
    public int singleNumber(int[] nums) {
        
        // check for invalid inputs
        if(nums.length == 0 || nums == null)
            return -1;
        
        //edge case
        if(nums.length == 1)
            return nums[0];
        
        // using hashMap
        // TC : O(n)
        // SC : O(n)
        HashMap<Integer,Integer> numsMap = new HashMap<Integer, Integer>();
        for(int i : nums)
            numsMap.put(i, numsMap.getOrDefault(i,0) + 1);
        
        for(int i : nums)
            if(numsMap.get(i) == 1)
                return i;
        
        return 0;
    }
}
