class Solution {
    public int numWays(String s) {
        int n=s.length(),r[]=new int[n+2],i,o=0;
        long ans=0,M=1000000007;
        for(i=n-1;i>=0;i--)
        {
            if(s.charAt(i)=='1') o++;
            r[i]=o;
        }
        
        int ones=o; o=0;
        for(i=0;i<n;i++)
        {
            if(s.charAt(i)=='1') o++;
            if(ones-2*o!=o) continue;
            int ri=rightmost(r,n,o)-leftmost(r,n,i,o)+1;
            ri=Math.max(ri,0);
            ans+=ri;
            ans%=M;
        }
        return (int)ans;
    }
    
    static int rightmost(int a[],int n,int o)
    {
        int l=0,r=n-1,mid,ans=0;
        while(l<=r)
        {
            mid=(l+r)/2;
            if(a[mid]>=o)
            {
                ans=mid;
                l=mid+1;
            }
            else r=mid-1;
        }
        return ans;
    }
    
    static int leftmost(int a[],int n,int i, int o)
    {
        int l=i+2,r=n-1,mid,ans=n;
        while(l<=r)
        {
            mid=(l+r)/2;
            if(a[mid]<=o)
            {
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }
}
