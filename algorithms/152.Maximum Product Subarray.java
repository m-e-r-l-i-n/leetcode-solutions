class Solution {
    public int maxProduct(int[] nums) {
        int res=nums[0],n=nums.length,i,l=0,r=0;
        for(i=0;i<n;i++)
        {
            l=(l==0?1:l)*nums[i];
            r=(r==0?1:r)*nums[n-i-1];
            res=Math.max(res,Math.max(l,r));
        }
        return res;
    }
}
