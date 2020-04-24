// https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3231/
// Given a non-empty array of integers, return the third maximum number in this array. 
// If it does not exist, return the maximum number. The time complexity must be in O(n).

class Solution {
    public int thirdMax(int[] nums) {
        
        //check for invalid inputs
        if(nums == null || nums.length == 0)
            return 0;
        
        //sort in descending order
        //sort
        Arrays.sort(nums);
        //reverse array in-place
        int q = nums.length - 1;
        int tmp = 0;
        for(int p = 0; p < nums.length/2; p++) {
            tmp = nums[p];
            nums[p] = nums[q];
            nums[q] = tmp;
            
            q--;
        }
        
        // find thirdMax
        int maxNum = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
        int flag = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= maxNum) {
                maxNum = nums[i];
            } else if(nums[i] >= secondMax) {
                secondMax = nums[i];
            } else if(nums[i] >= thirdMax) {
                thirdMax = nums[i];
                flag = 1; //corner case: to check if thirdMax value has been set
            }
        }
        
        return (thirdMax == Integer.MIN_VALUE && flag == 0) ? maxNum : thirdMax;
        
    }
}
