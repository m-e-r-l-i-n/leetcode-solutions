class MedianFinder {

    /** initialize your data structure here. */
    int bit[],N,c,X=100001;
    public MedianFinder() {
        N=200001; c=0;
        bit=new int[N+1];
    }
    
    public void addNum(int num) {
        num+=X;
        update(num);
        c++;
    }
    
    public double findMedian() {
        if(c==0) return 0;
        int k=c/2+1;
        int v1=smallest(k,1,N);
        if(c%2==1) return v1-X;
        int v2=smallest(k-1,1,v1);
        return (v1+v2-2*X)/2.0;
    }
    
    int smallest(int k,int l,int r)
    {
        int v,m,ans=r;
        while(l<=r)
        {
            m=(l+r)>>1;
            v=query(m);
            if(v>=k) 
            {
                ans=m;
                r=m-1;
            }
            else l=m+1;
        }
        return ans;
    }
    
    void update(int i)
    {
        while(i<=N)
        {
            bit[i]++;
            i+=i&-i;
        }
    }
    
    int query(int i)
    {
        int s=0;
        while(i>0)
        {
            s+=bit[i];
            i-=i&-i;
        }
        return s;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
