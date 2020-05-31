// https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1387/

/*
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Example:

MyStack stack = new MyStack();

stack.push(1);
stack.push(2);  
stack.top();   // returns 2
stack.pop();   // returns 2
stack.empty(); // returns false
Notes:

You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
*/

class MyStack {
    
    Queue<Integer> queue;
    Queue<Integer> temp;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<Integer>();
        temp = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if(queue.isEmpty()) {
            queue.offer(x);
        } else {
            
            if(queue.size() > 0) {
                temp.offer(x);
                while(queue.size() > 0)
                    temp.offer(queue.poll());
            } else if (temp.size() > 0) {
                queue.offer(x);
                while(temp.size() > 0)
                    queue.offer(temp.poll());
            }
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(queue.size() > 0)
            return queue.poll();
        else if(temp.size() > 0)
            return temp.poll();
        return 0;
    }
    
    /** Get the top element. */
    public int top() {
        if(queue.size() > 0)
            return queue.peek();
        else if(temp.size() > 0)
            return temp.peek();
        return 0;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty() && temp.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
