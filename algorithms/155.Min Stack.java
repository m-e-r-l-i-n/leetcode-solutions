class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> s=new Stack<>();
    int min=0;
    public MinStack() {
        min=2147483647;
    }
    
    public void push(int x) {
        if(x<=min)
        {
            s.push(min);    //adds 2nd min here and then pushes x
            min=x;
        }
        s.push(x);
    }
    
    public void pop() {
        if(min==s.pop())
            min=s.pop();    //pop both min and x here
    }
    
    public int top() {
        return s.peek();
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
