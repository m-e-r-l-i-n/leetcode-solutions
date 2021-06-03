class Solution {
    public int kthSmallest(int[][] a, int k) {
        int n=a.length,l=a[0][0],r=a[n-1][n-1],mid,ans=l;
        while(l<=r)
        {
            mid=(l+r)>>1;
            int i,j,c=0;
            for(i=0;i<n;i++)
            {
                int u=0,v=n-1,m,add=0;
                while(u<=v)
                {
                    m=(u+v)>>1;
                    if(a[i][m]<=mid)
                    {
                        add=m+1;
                        u=m+1;
                    }
                    else v=m-1;
                }
                c+=add;
                if(c>=k) break;
            }
            
            if(c>=k) 
            {
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }
}
