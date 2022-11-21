class Solution {
    public int unequalTriplets(int[] nums) {
        int i,j,k,n=nums.length,ans=0;
        for(i=0;i<n;i++)
        for(j=i+1;j<n;j++)
        if(nums[i]!=nums[j])
        for(k=j+1;k<n;k++)
        if(nums[j]!=nums[k] && nums[i]!=nums[k]) ans++;
        return ans;
    }
}
