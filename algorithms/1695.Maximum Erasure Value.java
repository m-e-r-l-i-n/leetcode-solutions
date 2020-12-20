class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int i=0,n=nums.length,j=1;
        Set<Integer> set=new HashSet<>();
        set.add(nums[0]);
        int sum=nums[0],maxsum=sum;
 
        while(i<n-1 && j<n) 
        {
            if(!set.contains(nums[j])) 
            {
                sum=sum+nums[j];
                maxsum=Math.max(sum, maxsum);
                set.add(nums[j++]);
            }
            else 
            {
                sum-=nums[i];
                set.remove(nums[i++]);
            }
        }
 
        return maxsum;
    }
}
