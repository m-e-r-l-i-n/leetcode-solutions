class Solution {
    public int findNumberOfLIS(int[] nums) {
        if(nums.length<=1) return nums.length;
    
        int n=nums.length,omax=0,ans=0,l[]=new int[n],c[]=new int[n],i,j;
        for(i=0;i<n;i++)
        {
            boolean flag=true;
            for(j=0;j<i;j++)
            if(nums[i]>nums[j])
            {
                flag=false;
                if(l[j]+1>l[i])
                {
                    l[i]=l[j]+1;
                    c[i]=c[j];
                }
                else if(l[j]+1==l[i]) c[i]+=c[j];
            }
            if(flag) l[i]=c[i]=1;
            if(l[i]>omax)
            {
                omax=l[i];
                ans=c[i];
            }
            else if(l[i]==omax) ans+=c[i];
        }
        return ans;
    }
}
