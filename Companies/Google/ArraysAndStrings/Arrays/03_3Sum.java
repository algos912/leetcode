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

// two pointers
// TC : O(n2)
// SC : O(n)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(i == 0 || nums[i-1] != nums[i])
                twoSum(nums, i , output);
        }
        return output;  
    }
    
    public void twoSum(int[] nums, int i, List<List<Integer>> output) {
        int low = i+1;
        int high = nums.length - 1;
        int sum = 0;
        while(low < high) {
            sum = nums[i] + nums[low] + nums[high];
            if(sum < 0) {
                low++;
            } else if(sum > 0) {
                high--;
            } else {
                //threeSumList.add(nums[i]);
                //threeSumList.add(nums[low++]);
                //threeSumList.add(nums[high--]);
                //output.add(threeSumList);
                output.add(Arrays.asList(nums[i], nums[low++], nums[high--]));
                while(low < high && nums[low] == nums[low-1])
                    low++;
            }
        }
    }
}
