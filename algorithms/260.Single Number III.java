class Solution {
    public int[] singleNumber(int[] nums) {
        int ans=0,i,j,n=nums.length;
        for(i=0;i<n;i++)
            ans^=nums[i];
        ans&=-ans;  //biggest set bit
        int a[]={0,0};
        for(i=0;i<n;i++)
        if((ans&nums[i])==0) a[0]^=nums[i]; //bit not set
        else a[1]^=nums[i];
        return a;
    }
}
