// https://leetcode.com/explore/learn/card/binary-search/144/more-practices/1029/
// Given two arrays, write a function to compute their intersection.

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // check for invalid inputs
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[] {};
        
        HashMap<Integer,Integer> map1 = new HashMap<Integer,Integer>();
        for(int i : nums1) {
            if(map1.containsKey(i)) {
                map1.put(i, map1.get(i)+1);
            } else {
                map1.put(i, 1);
            }           
        }
        
        // finding intersection using set
        ArrayList<Integer> intersectedList = new ArrayList<Integer>();
        for(int i : nums2) {
            if(map1.containsKey(i)) {
                if(map1.get(i) > 1) {
                    map1.put(i, map1.get(i)-1);
                } else {
                    map1.remove(i);
                }
                
                //add intersection to output list
                intersectedList.add(i);
            }
        }
        
        // convert set to array
        int[] output = new int[intersectedList.size()];
        int index = 0;
        for(int i : intersectedList) {
            output[index] = i;
            index++;
        }
        
        // return the array output
        return output;
    }
}
