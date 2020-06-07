class Solution {
    public int[] shuffle(int[] nums, int n) {
        int ans[]=new int[2*n],t=0,i;
        for(i=0;i<n;i++)
        {ans[t]=nums[i];
        t+=2;}
        t=1;
        for(i=n;i<2*n;i++)
        {ans[t]=nums[i];
        t+=2;}
        return ans;
    }
}
