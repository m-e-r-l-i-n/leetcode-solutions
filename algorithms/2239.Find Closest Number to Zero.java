//Tamonash Chakraborty
//O(n)
class Solution {
    public int findClosestNumber(int[] nums) {
        int ans=nums[0],i;
        for(i=1;i<nums.length;i++)
        {
            int d1=Math.abs(nums[i]),d2=Math.abs(ans);
            if(d1<d2) ans=nums[i];
            else if(d1==d2 && ans<nums[i]) ans=nums[i];
        }    
        return ans;
    }
}
