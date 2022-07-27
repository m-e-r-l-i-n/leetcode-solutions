class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans=0,l=0;
        for(int x:nums)
        {
            if(x==0) l++;
            else l=0;
            ans+=l;
        }
        return ans;
    }
}
