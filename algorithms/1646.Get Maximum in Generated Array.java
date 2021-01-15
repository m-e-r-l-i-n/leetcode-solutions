class Solution {
    public int getMaximumGenerated(int n) {
        if(n<2) return n;
        int a[]=new int[n+1],i,m=0;
        a[1]=1;
        for(i=1;i<=n/2;i++)
        {
            if(2*i<=n) {a[2*i]=a[i]; m=Math.max(m,a[2*i]);}
            if(2*i+1<=n) {a[2*i+1]=a[i]+a[i+1]; m=Math.max(m,a[2*i+1]);}
        }
        return m;
    }
}
