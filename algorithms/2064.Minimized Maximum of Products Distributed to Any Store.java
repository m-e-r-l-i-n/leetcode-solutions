//Tamonash Chakraborty
//O(mlogm)
class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int l=1,r=(int)1e6,mid,ans=r;
        while(l<=r)
        {
            mid=(l+r)>>1;
            if(possible(quantities,mid,n))
            {
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }
    
    boolean possible(int a[],int m,int n)
    {
        int r=0;
        for(int x:a)
        {
            r+=x/m;
            if(x%m!=0) r++;
        }
        return r<=n;
    }
}
