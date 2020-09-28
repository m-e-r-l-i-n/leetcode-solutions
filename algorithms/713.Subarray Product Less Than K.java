class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k==0) return 0;
        
        int i,n=nums.length,c=0,p=1,j;
        for(i=0,j=0;j<n;j++)
        {
            p*=nums[j]; 
            while(p>=k && i<=j)
            {
                p/=nums[i++];
            }
            c+=j-i+1;
        }
        return c;
    }
}
