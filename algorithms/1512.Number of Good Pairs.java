class Solution {
    public int numIdenticalPairs(int[] nums) {
        int i,c[]=new int[101],ans=0;
        for(i=0;i<nums.length;i++)
            c[nums[i]]++;
        for(i=1;i<=100;i++)
            ans+=c[i]*(c[i]-1)/2;
        return ans;
    }
}
