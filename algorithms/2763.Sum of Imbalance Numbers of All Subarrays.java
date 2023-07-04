class Solution {
    public int sumImbalanceNumbers(int[] nums) {
        int i,j,n=nums.length,c[]=new int[n+3],ans=0;
        for(i=0;i<n;i++)
        {
            ans+=(n-i-1)*(n-i)/2;
            
            c[nums[i]]++;
            int ded=0;
            for(j=i+1;j<n;j++)
            {
                if(c[nums[j]]>0) ded++;
                else
                {
                    if(c[nums[j]-1]>0) ded++;
                    if(c[nums[j]+1]>0) ded++;
                }
                c[nums[j]]++;
                ans-=ded;
            }
            
            for(j=i;j<n;j++) c[nums[j]]--;
        }
        return ans;
    }
}
