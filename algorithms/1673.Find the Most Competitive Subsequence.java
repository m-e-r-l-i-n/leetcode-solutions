class Solution {
    public int[] mostCompetitive(int[] a, int k) {
        int ans[]=new int[k],i,n=a.length;
        Arrays.fill(ans,Integer.MAX_VALUE);
        int last=-1;
        for(i=0;i<n;i++)
        {
            int r=n-i;
            int l=Math.max(k-r,0);
            if(last<l) {ans[++last]=a[i]; continue;}
            int in=smallest(l,last,ans,a[i]);
            if(in<k) 
            {
                ans[in]=a[i];
                last=in;
            }
        }
        return ans;
    }
    
    int smallest(int l,int r,int a[],int k)
    {
        int mid,ans=r;
        if(k>=a[r]) return r+1;
        while(l<=r)
        {
            mid=(l+r)>>1;
            if(a[mid]>k)
            {
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }
}
