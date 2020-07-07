// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3381/
// https://leetcode.com/problems/hamming-distance/solution/
/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.
*/

class Solution {
    public int hammingDistance(int x, int y) {
        // the bit operation called XOR which outputs 1 if and only if the input bits are different.
        return Integer.bitCount(x ^ y);
    }
}
