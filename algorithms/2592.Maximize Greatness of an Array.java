class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int i,n=nums.length,j=0,ans=0;
        for(i=0;i<n;i++)
        {
            j=Math.max(j,i+1);
            while(j<n && nums[j]<=nums[i]) j++;
            if(j!=n)
            {
                j++;
                ans++;
            }
        }
        return ans;
    }
}
