class Solution {
    public int candy(int[] r) {
        int i,n=r.length,a[]=new int[n];
        for(i=0;i<n;i++)
        {
            a[i]=1;
            if(i>0 && r[i]>r[i-1]) a[i]=a[i-1]+1;
        }
        int ans=0;
        for(i=n-1;i>0;i--)
        {
            if(r[i-1]>r[i]) a[i-1]=Math.max(a[i-1],a[i]+1);
            ans+=a[i];
        }
        ans+=a[0];
        return ans;
    }
}
