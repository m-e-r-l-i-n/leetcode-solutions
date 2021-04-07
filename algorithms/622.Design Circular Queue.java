class MyCircularQueue {
    int a[],l,r,s;
    public MyCircularQueue(int k) {
        a=new int[k];
        l=0; r=-1; s=k;
    }
    
    public boolean enQueue(int value) {
        if(isEmpty())
        {
            r=0;
            a[r]=value;
            return true;
        }   
        if(!isFull())
        {
            r=(r+1)%s;
            a[r]=value;
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        if(!isEmpty())
        {
            if(l==r) {l=0;r=-1;}
            else l=(l+1)%s;
            return true;
        }
        return false;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return a[l];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return a[r];
    }
    
    public boolean isEmpty() {
        return r==-1;
    }
    
    public boolean isFull() {
        return !isEmpty() && (r+1)%s==l;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
