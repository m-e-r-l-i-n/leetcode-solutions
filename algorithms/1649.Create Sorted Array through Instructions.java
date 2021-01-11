class Solution {
    public int createSortedArray(int[] a) 
    {
        int i,N=100010;
        bit=new int[N+1];
        long ans=0;
        for(i=0;i<a.length;i++)
        {
            int sm=query(a[i]-1),lar=query(a[i])-sm;
            lar=i-sm-lar;
            ans+=Math.min(sm,lar);
            update(a[i],N);
        }
        ans%=1000000007;
        return (int)ans;
    }
    int bit[];
    
    void update(int i,int n)
    {
        i++;
        while(i<=n)
        {
            bit[i]++;
            i+=i&-i;
        }
    }
    
    int query(int i)
    {
        i++;
        int sum=0;
        while(i>0)
        {
            sum+=bit[i];
            i-=i&-i;
        }
        return sum;
    }
}
