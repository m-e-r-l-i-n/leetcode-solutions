//Tamonash Chakraborty
//O(n*log(max(candies[i])))
class Solution {
    public int maximumCandies(int[] candies, long k) {
        int l=1,r=(int)1e7,ans=0,mid;
        while(l<=r)
        {
            mid=(l+r)>>1;
            if(possible(candies,mid,k))
            {
                ans=mid;
                l=mid+1;
            }
            else r=mid-1;
        }
        return ans;
    }
    
    boolean possible(int a[],int m,long k)  //see if we can give m candies to k children
    {
        long c=0;
        for(int x:a)
        c+=x/m; //break into as many piles of m as possible
        return c>=k;
    }
}
