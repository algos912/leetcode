// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/283/

/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

// TC : O(n2)
// SC : O(n)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        Set<Pair> found = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
        Set<Integer> seen = new HashSet<>();
        for (int j = i + 1; j < nums.length; ++j) {
            int complement = -nums[i] - nums[j];
            if (seen.contains(complement)) {
                int v1 = Math.min(nums[i], Math.min(complement, nums[j]));
                int v2 = Math.max(nums[i], Math.max(complement, nums[j]));
                if (found.add(new Pair(v1, v2)))
                    res.add(Arrays.asList(nums[i], complement, nums[j]));
            }
            seen.add(nums[j]);
        }
        }
        return res;
        
    }
}
