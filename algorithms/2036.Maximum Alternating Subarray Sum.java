//Tamonash Chakraborty
//O(n)
class Solution {
    public long maximumAlternatingSubarraySum(int[] nums) {
        int n=nums.length,i;
        long odd=nums[0],even=0,ans=odd;
        for(i=1;i<n;i++)
        {
            long codd=Math.max(nums[i],even+nums[i]);	//make it odd place element, or 1st element
            long ceven=odd-nums[i];	//make it running even place elenment
            
            odd=codd;
            even=ceven;
			ans=Math.max(ans,odd);
            ans=Math.max(ans,even);
        }
        return ans;
    }
}
