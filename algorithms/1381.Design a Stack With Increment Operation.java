class CustomStack {
    int size,top,a[];
    public CustomStack(int maxSize) {
        size=maxSize;
        a=new int[size];
        top=-1;
    }
    
    public void push(int x) {
        if(top<size-1) a[++top]=x;
    }
    
    public int pop() {
        if(top==-1) return -1;
        int x=a[top--];
        return x;
    }
    
    public void increment(int k, int val) {
        k=Math.min(top+1,k);
        int i;
        for(i=0;i<k;i++)
            a[i]+=val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
