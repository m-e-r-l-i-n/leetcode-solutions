class Solution {
    public int minStartValue(int[] nums) {
        int n=nums.length,i,max=1,v=1;
        for(i=0;i<n;i++)
        {
            v+=nums[i];
            if(v<1) {max+=1-v; v+=1-v;}
        }
        return max;
    }
}
