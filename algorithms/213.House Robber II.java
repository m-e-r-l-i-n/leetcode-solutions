class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        return Math.max(rob(nums,0,n-1),rob(nums,1,n));
    }
    
    int rob(int a[],int s,int e)
    {
        int i,py=0,pn=0;
        for(i=s;i<e;i++)
        {
            int t=pn;
            pn=Math.max(pn,py);
            py=t+a[i];
        }
        return Math.max(pn,py);
    }
}
