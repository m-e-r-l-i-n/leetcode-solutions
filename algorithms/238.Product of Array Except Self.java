class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length,i,pre[]=new int[n+1],post[]=new int[n+1];
        pre[0]=1; post[n]=1;
        for(i=0;i<n;i++)
        pre[i+1]=pre[i]*nums[i];
        for(i=n-1;i>=0;i--)
        post[i]=post[i+1]*nums[i];
        for(i=0;i<n;i++)
        nums[i]=pre[i]*post[i+1];
        return nums;
    }
}
