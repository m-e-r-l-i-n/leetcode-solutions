class Solution {
    public int minimizeArrayValue(int[] nums) {
        int l=0,r=0,mid,ans;
        for(int x:nums) r=Math.max(x,r);
        ans=r;
        
        while(l<=r)
        {
            mid=(l+r)>>1;
            if(possible(nums,mid))
            {
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }
    
    boolean possible(int a[],int m)
    {
        int n=a.length,i;
        long add=0;
        for(i=n-1;i>0;i--)
        {
            add+=a[i];
            add-=Math.min(add,m);
        }
        return add+a[0]<=m;
    }
}
