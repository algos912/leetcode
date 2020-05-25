// https://leetcode.com/explore/learn/card/binary-search/135/template-iii/945/
// Given a sorted array arr, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> result = new ArrayList<>();
        int minDiffIndex = 0;
        int minValue = Integer.MAX_VALUE;
		
        // Linear search of the target element x
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i] - x) < minValue) {
                minValue = Math.abs(arr[i] - x);
                minDiffIndex = i;
            }
        }
		//Add the first Element at the minDiffIndex to the result.
        result.add(arr[minDiffIndex]);
		
        
        //Lets have 2 different index, one which moves left from the minDiffIndex and right which moves right from the minDiffIndex.
        int left = minDiffIndex - 1;
        int right = minDiffIndex + 1;
        while (result.size() < k) {
            if (left >= 0 && right < arr.length) {
			//Check in which direction we are getting closer element, add that.
                if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                    result.add(0, arr[left]);
                    left--;
                } else {
                    result.add(result.size(), arr[right]);
                    right++;
                }
            } 
			//If right has reached the end of the arr, then add left element.
			else if (left >= 0) {
                result.add(0, arr[left]);
                left--;
            } 
			//If left has reached the start of the arr, then add right element.
			else if (right < arr.length) {
                result.add(result.size(), arr[right]);
                right++;
            } else {
                break;
            }
        }
        return result;
        
    }
}
