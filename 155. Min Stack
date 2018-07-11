class MinStack {
    Stack<Long> stack;
    long min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = 0;
    }
    
    public void push(int x) {
        if(stack.isEmpty()) min = x;
        stack.push(x - min);
        System.out.println(x-min);
        if(x < min) {
            min = x;
        }
        
    }
    
    public void pop() {
        if(stack.peek() < 0) min = min - stack.peek();
        stack.pop();
    }
    
    public int top() {
        return stack.peek() > 0?(int)(stack.peek() + min) : (int)min;
    }
    
    public int getMin() {
        return (int)min;
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
