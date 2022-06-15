//Tamonash Chakraborty
//O(nlogn)
//binary search
class Solution {
    public long countSubarrays(int[] nums, long k) {
        int i,n=nums.length;
        long ans=0,sum[]=new long[n+1];
        for(i=1;i<=n;i++) 
        {
            sum[i]=sum[i-1]+nums[i-1];
            int l=1,r=i,mid,here=i+1;
            while(l<=r) //binary search
            {
                mid=(l+r)>>1;
                long v=sum[i]-sum[mid-1];   //sum
                v*=i-mid+1; //length
                if(v<k)
                {
                    here=mid;
                    r=mid-1;
                }
                else l=mid+1;
            }
            ans+=i-here+1;
        }
        return ans;
    }
}
