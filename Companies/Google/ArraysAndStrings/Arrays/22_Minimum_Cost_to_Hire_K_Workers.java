// Minimum Cost to Hire K Workers
/*
There are N workers.  The i-th worker has a quality[i] and a minimum wage expectation wage[i].

Now we want to hire exactly K workers to form a paid group.  When hiring a group of K workers, we must pay them according to the following rules:

Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group.
Every worker in the paid group must be paid at least their minimum wage expectation.
Return the least amount of money needed to form a paid group satisfying the above conditions.

 

Example 1:

Input: quality = [10,20,5], wage = [70,50,30], K = 2
Output: 105.00000
Explanation: We pay 70 to 0-th worker and 35 to 2-th worker.
Example 2:

Input: quality = [3,1,10,10,1], wage = [4,8,2,2,7], K = 3
Output: 30.66667
Explanation: We pay 4 to 0-th worker, 13.33333 to 2-th and 3-th workers seperately. 
 

Note:

1 <= K <= N <= 10000, where N = quality.length = wage.length
1 <= quality[i] <= 10000
1 <= wage[i] <= 10000
Answers within 10^-5 of the correct answer will be considered correct.
*/

// SOLUTION:
// The key to the solution is that Kth ratio (wage / quality) can only satisfy workers with a smaller ratio. 
    // Otherwise, it will break the minimum expectation constraint, since every worker will be sharing the same ratio. 
    // However, you cannot simply pick the first Kth workers. Since if the sum of the quality is super high, 
    // then we would rather have a higher ratio but smaller sum of quality. 
    // Therefore, we are looking for the minimum sum of quality * ratio. Following is how the algorithm works:
    
    // 1. Create an array that stores the ratio (worker[0]) and quality (worker[1]). 
    //     We don't care about the min wage expectation anymore, 
    //     since we are only looking at the workers with a ratio that is smaller than any current ratio, 
    //     and will always satisfy the minimum constraint.
    // 2. Sort the array and start from Kth smallest ratio. 
    //     Otherwise, there won't be enough workers that satisfy with the current ratio (minimum constraint breaks)
    // 3. Keep increase the current ratio with the next worker and find the smallest sum, since both the sum of quality and ratio impacts the result
    // 4. Keep removing the largest quality, since we want the smallest sum of quality and the smallest ratio possible

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        // ratio (worker[0]) and quality (worker[1])
        double[][] workers = new double[quality.length][2];
        for (int i = 0; i < quality.length; i++) {
            workers[i][0] = (double) wage[i] / quality[i];
            workers[i][1] = (double) quality[i];
        }
        //smallest ratio first, so we can make sure that we don't violate the minimum expectation rule
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        // use a priority queue to remove the larest quality, sorted with the larest quality ahead
        PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> (int) (b - a));
        double result = Double.MAX_VALUE, qsum = 0;
        for (double[] w : workers) {
            qsum += w[1];
            pq.add(w[1]);
            // if we have more than k workers, remove the one with the largest quality
            if (pq.size() > K) {
                qsum -= pq.poll();
            }
            if (pq.size() == K) {
                result = Math.min(result, qsum * w[0]);
            }
        }
        return result;
    }
}
