// 3Sum
/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []
 

Constraints:

0 <= nums.length <= 3000
-105 <= nums[i] <= 105

*/

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
