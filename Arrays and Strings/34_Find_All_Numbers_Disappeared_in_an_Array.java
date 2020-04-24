// https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3270/
// Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
// Find all the elements of [1, n] inclusive that do not appear in this array.
// Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> missingNumbers = new ArrayList<Integer>();
        
        //check for invalid inputs
        if(nums == null || nums.length == 0)
            return missingNumbers;
        
        // n is from 1 to len
        // Brute Force : TC : O(n2), SC: O(1), Time Limit Exceeded
        /*
        int found = 0;
        for(int n = 1; n <= nums.length; n++) {
            // check if value of n appears in the input array
            found = 0;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] == n) {
                    found = 1;
                    break;
                }
            }
            //if n is not found in the input array, add it to missingNumbers list
            if(found == 0) {
                missingNumbers.add(n);
            }   
        }
        */
        
        // 2. use a hashMap 
        // TC: O(n), SC: O(n)
        int found = 0;
        HashMap<Integer,Integer> numMap = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++) {
            numMap.put(nums[i],i);
        }
        
        //find missing numbers in input array
        for(int n = 1; n <= nums.length; n++){
            if(numMap.containsKey(n))
                continue;
            else
                missingNumbers.add(n);
        }
        
        //return the list of missing numbers
        return missingNumbers;
        
        
    }
}
