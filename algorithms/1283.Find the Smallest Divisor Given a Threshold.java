class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l=1,r=1000000,mid,ans=r;
        while(l<=r)
        {
            mid=(l+r)/2;
            if(possible(nums,mid,threshold))
            {
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }
    
    boolean possible(int a[],int m,int t)
    {
        int c=0,i,n=a.length;
        for(i=0;i<n;i++)
        c+=(a[i]+m-1)/m;
        return c<=t;
    }
}
