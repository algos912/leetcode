// https://leetcode.com/explore/learn/card/queue-stack/228/first-in-first-out-data-structure/1368/
// Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

// TC : O(n)
// SC : O(n)

class MovingAverage {
    Queue<Integer> q;
    int size;
    double sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.q = new LinkedList();
        this.size = size;
    }
    
    public double next(int val) {
        sum += val;
        
        // push the value into the queue
        q.offer(val);
        
        // find average
        if(q.size() <= size) {
            return sum/q.size();
        }
        
        // pop first element from queue
        sum -= q.poll();
        
        return sum/size;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
