//Tamonash Chakraborty
//O(nlogn)
class Solution {
    public long repairCars(int[] ranks, int cars) {
        long l=0,r=(long)1e15,mid,ans=r;
        while(l<=r)
        {
            mid=(l+r)>>1;
            if(possible(ranks,cars,mid))
            {
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }
    
    boolean possible(int ranks[],int cars,long m)
    {
        for(int r:ranks)
        {
            long x2=m/r,x=root(x2);
            cars-=x;
            if(cars<=0) return true;
        }
        return false;
    }
    
    long root(long n)
    {
        long l=1,r=(int)1e9,mid,ans=0;
        while(l<=r)
        {
            mid=(l+r)>>1;
            if(mid*mid<=n)
            {
                ans=mid;
                l=mid+1;
            }
            else r=mid-1;
        }
        return ans;
    }
}
