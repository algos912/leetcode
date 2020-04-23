// https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3250/
// Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).

class Solution {
    public boolean checkIfExist(int[] arr) {
        
        // check for invalid inputs
        if(arr == null || arr.length == 0)
            return false;
        
        // 1. Brute Force Solution
        // TC : O(n2), SC : O(1)
        /*
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++) {
                if(2*arr[i] == arr[j] || arr[i] == 2*arr[j])
                    return true;
            }
        }
        return false;
        */
        
        // 2. Use a hash map
        // TC: O(n), SC: O(n)
        HashMap<Integer,Integer> arrMap = new HashMap<Integer,Integer>();
        int val = 0;
        for(int i = 0; i < arr.length; i++) {
            //for checking for values not divisible by 2
            if(arr[i] % 2 == 0)
                val = arr[i] / 2;
            else
                val = arr[i]*2;
            
            //look for values input hashMap
            if(arrMap.containsKey(arr[i]*2) || arrMap.containsKey(val))
                return true;
            else
                arrMap.put(arr[i],i);
        }
        return false;
        
    }
}
