//Tamonash Chakraborty
//O(nlog(n))
class Solution {
    public long minimumTime(int[] time, int tot) {
        long l=0,r=(long)1e15,mid,ans=r;
        while(l<=r) //binary search the answer
        {
            mid=(l+r)>>1;
            if(possible(time,tot,mid))
            {
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }
    
    boolean possible(int time[],int tot,long mid)
    {
        long how=0; //how many trips can be made in total in mid time
        for(int x:time)
        {
            how+=mid/x;
            if(how>=tot) return true;
        }
        return false;
    }
}
