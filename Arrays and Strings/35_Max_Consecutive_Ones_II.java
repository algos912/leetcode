// https://cheonhyangzhang.gitbooks.io/leetcode-solutions/content/solutions-451-500/487-max-consecutive-ones-ii.html
// Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.

// Follow up: What if the input numbers come in one by one as an infinite stream? 
// In other words, you can't store all numbers coming from the stream as it's too large to hold in memory. 
// Could you solve it efficiently?

// LEETCODE PREMIUM
// copied solution.. try again..

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, cur = 0, cnt = 0;
        for (int i = 0; i < nums.length; i ++) {
            cnt ++;
            if (nums[i] == 0) {
                cur = cnt;
                cnt = 0;
            } 
            res = Math.max(res, cnt + cur);
        }
        return res;
    }
}
