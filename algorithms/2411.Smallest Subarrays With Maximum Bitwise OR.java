class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int next[]=new int[30],n=nums.length,ans[]=new int[n];
        for(int i=n-1;i>=0;i--)
        {
            int max=i,j;
            for(j=0;j<30;j++)
            if(((nums[i]>>j)&1)==1) next[j]=i;
            
            for(j=0;j<30;j++)
            max=Math.max(max,next[j]);
            ans[i]=max-i+1;
        }
        return ans;
    }
}
