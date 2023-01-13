class Solution {
    public long maxPower(int[] stations, int rad, int k) {
        int i,n=stations.length;
        long temp[]=new long[n+1],add[]=new long[n+1];
        for(i=0;i<n;i++)
        {
            temp[Math.max(0,i-rad)]+=stations[i];
            temp[Math.min(i+rad+1,n)]-=stations[i];
        }
        for(i=1;i<=n;i++) temp[i]+=temp[i-1];   //how many are sending power to it right now
        
        long l=0,r=(long)1e15,mid,ans=l;
        while(l<=r)
        {
            mid=(l+r)>>1;
            if(possible(temp,add,mid,rad,k))
            {
                ans=mid;
                l=mid+1;
            }
            else r=mid-1;
        }
        return ans;
    }
    
    boolean possible(long t[],long add[],long mid,int r,long k)
    {
        int i,n=t.length-1;
        for(i=0;i<=n;i++) add[i]=0;
        long cur=0;
        for(i=0;i<n;i++)
        {
            cur-=add[i];
            long need=Math.max(0,mid-t[i]-cur);
            if(need>k) return false;
            
            k-=need;
            cur+=need;
            add[Math.min(n,i+2*r+1)]+=need;
        }
        return true;
    }
}
