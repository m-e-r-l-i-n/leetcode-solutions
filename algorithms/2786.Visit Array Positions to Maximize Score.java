class Solution {
    public long maxScore(int[] nums, int x) {
        long score[]=new long[2];
        score[nums[0]%2]=nums[0];
        score[(nums[0]%2)^1]=-(long)1e18;
        for(int i=1;i<nums.length;i++)
        {
            int parity=nums[i]%2;
            score[parity]=Math.max(score[parity]+nums[i],score[parity^1]-x+nums[i]);
        }
        return Math.max(score[0],score[1]);
    }
}
