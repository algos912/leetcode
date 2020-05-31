// https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1360/
// https://leetcode.com/problems/min-stack/discuss/49014
/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/

class MinStack {
    
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        // only push the old minimum value when the current 
        // minimum value changes after pushing the new value x
        if(x <= min){          
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

// SOLUTION - 2 : USING TWO STACKS
/*
class MinStack {
    
    private Stack<Integer> stack;
    private Stack<Integer> min_stack;

    // initialize your data structure here.
    public MinStack() {
        this.stack=new Stack();
        this.min_stack=new Stack();
    }
    
    public void push(int x) {
        if(min_stack.isEmpty() || x<=min_stack.peek()){
            min_stack.push(x);
        }
        stack.push(x);
    }
    
    public void pop() 
    {
        if(stack.peek().equals(min_stack.peek())){
            min_stack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min_stack.peek();
    }
}
*/

// SOLUTION -3 : WITHOUT USING IN-BUILT STACK
/*
class MinStack {
	Node head;
	int min;
	// initialize your data structure here.
	public MinStack() {
	    head=null;
	    min=999999;
	}

	public void push(int x) {
		if(head==null){
			head=new Node(x);
			min=x;
			Node temp=new Node(min);
			temp.next=head;
			head=temp;
			return;
		}
		if(x<min)
			min=x;
		Node temp=new Node(min);
		temp.next=head;
		Node temp2=new Node(x);
		temp2.next=temp;
		head=temp2;

	}

	public void pop() {
		Node temp=head.next.next;
		head=head.next.next;
		if(temp==null)min=999999;
		else
		min=temp.next.data;
	}

	public int top() {
		return head.data;
	}

	public int getMin() {
		return head.next.data;
	}
}
class Node{
	int data;
	Node next;
	public Node(int data){
		this.data=data;
	}
}
*/
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
