// https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1178/

/*
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/

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
        
        // finding intersection
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
        
        // convert intersectedList to array
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
