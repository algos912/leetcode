// https://leetcode.com/explore/learn/card/recursion-i/253/conclusion/1675/
// https://leetcode.com/problems/k-th-symbol-in-grammar/solution/
/*
On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

Given row N and index K, return the K-th indexed symbol in row N. (The values of K are 1-indexed.) (1 indexed).

Examples:
Input: N = 1, K = 1
Output: 0

Input: N = 2, K = 1
Output: 0

Input: N = 2, K = 2
Output: 1

Input: N = 4, K = 5
Output: 1

Explanation:
row 1: 0
row 2: 01
row 3: 0110
row 4: 01101001
Note:

N will be an integer in the range [1, 30].
K will be an integer in the range [1, 2^(N-1)].
*/

class Solution {
    
    public int kthGrammar(int N, int K) {
        
        // SOLUTION 1 : BRUTE FORCE (MEMORY LIMIT EXCEEDED)
        // TC : O(2^N)
        // SC : O(2^N)
        /*
        int[] lastrow = new int[1 << N];
        for (int i = 1; i < N; ++i) {
            for (int j = (1 << (i-1)) - 1; j >= 0; --j) {
                lastrow[2*j] = lastrow[j];
                lastrow[2*j+1] = 1 - lastrow[j];
            }
        }
        return lastrow[K-1];
        */
        
        // SOLUTION 2 : RECURSION
        // TC : Time Complexity: O(N). It takes N-1 steps to find the answer.
        // SC : O(N)
        if (N == 1) return 0;
        return (~K & 1) ^ kthGrammar(N-1, (K+1)/2);
        
    }
}
