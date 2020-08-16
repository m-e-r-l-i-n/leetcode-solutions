class Solution {
    public int maxDistance(int[] p, int m) {
        Arrays.sort(p);
        int l=0,r=1000000000,ans=0,mid;
        while(l<=r)
        {
            mid=(l+r)/2;
            if(possible(p,mid,m))
            {ans=mid; l=mid+1;}
            else r=mid-1;
        }
        return ans;
    }
    
    boolean possible(int a[],int m,int k)
    {
        int i,c=1,prev=a[0];
        for(i=1;i<a.length;i++)
        {
            if(a[i]-prev>=m)
            {prev=a[i]; c++;}
            if(c>=k) return true;
        }
        return c>=k;
    }
}
