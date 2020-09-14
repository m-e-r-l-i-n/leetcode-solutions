class Solution {
    public int rob(int[] nums) {
        int i,n=nums.length,prevn=0,prevy=0;
        for(i=0;i<n;i++)
        {
            int t=prevn;
            prevn=Math.max(prevn,prevy);
            prevy=t+nums[i];
        }
        return Math.max(prevn,prevy);
    }
}
