class Solution {
    public int minDifference(int[] nums) {
        if(nums.length<=4) return 0;
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE,i,n=nums.length;
        for(i=0;i<4;i++)
        min=Math.min(min,nums[n-4+i]-nums[i]);
        return min;
    }
}
