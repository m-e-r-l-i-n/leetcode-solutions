class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int st=0,e=0,sum=0,min=Integer.MAX_VALUE;
        while(e<nums.length)
        {
            sum+=nums[e++];
            while(sum>=s)
            {
                min=Math.min(min,e-st);
                sum-=nums[st++];
            }            
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
