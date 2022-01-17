//Tamonash Chakraborty
//O(n.log(sum(batteries)))
class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long l=1,r=(long)(1e16/n),mid,ans=l;
        while(l<=r)	//binary search
        {
            mid=(l+r)>>1;
            if(possible(batteries,n,mid))
            {
                ans=mid;
                l=mid+1;
            }
            else r=mid-1;
        }
        return ans;
    }
    
    boolean possible(int a[],int n,long k)
    {
        long tot=k*n;
        long sum=0;
        //1 battery can run a minimum of (k, its lifetime) 
        for(int x:a) sum+=Math.min(x,k);
        return sum>=tot;
    }
}
