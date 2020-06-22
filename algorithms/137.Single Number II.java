class Solution {
    public int singleNumber(int[] nums) {
        int c,i,j,ans=0;
        for(i=0;i<32;i++)
        {
            c=0;
            for(j=0;j<nums.length;j++)
            if(((nums[j]>>i)&1)!=0) c++;
            c%=3;
            ans|=c<<i;
        }
        return ans;
    }
}
