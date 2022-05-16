//Tamonash Chakraborty
//O(n)
class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum=0;
        for(int x:nums) sum+=x;
        
        long pre=0;
        int i,n=nums.length,ans=0;
        for(i=0;i<n-1;i++)
        {
            pre+=nums[i];
            if(sum-pre<=pre) ans++;
        }
        return ans;
    }
}
