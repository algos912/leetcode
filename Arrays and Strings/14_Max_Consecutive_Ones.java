// https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1301/
// Given a binary array, find the maximum number of consecutive 1s in this array.

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // check for invalid inputs
        if(nums == null || nums.length == 0)
            return 0;
        
        int k = 0;
        int maxK = 0;
        for(int i = 0; i < nums.length; i++) {
            // check for consecutive ones
            if(nums[i] == 1) {
                k++;
                if(k > maxK)
                    maxK = k;
            }
            // restart k count from zero, if number other than one is encountered
            else
                k = 0;
        }
        // return max number of consecutive ones
        return maxK;
        
    }
}
