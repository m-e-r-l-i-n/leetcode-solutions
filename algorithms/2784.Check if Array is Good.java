class Solution {
    public boolean isGood(int[] nums) {
        int n=nums.length,c[]=new int[n];
        n--;
        for(int x:nums) 
        if(x<=n) c[x]++;
        
        int i;
        for(i=1;i<n;i++)
        if(c[i]!=1) return false;
        return c[n]==2;
    }
}
