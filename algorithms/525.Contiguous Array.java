class Solution {
    public int findMaxLength(int[] nums) {
        int i,s=0,max=0,n=nums.length,a[]=new int[2*n+1];
        a[n]=1;
        for(i=0;i<nums.length;i++)
        {
            if(nums[i]==0) s-=1;
            else s+=1;
            if(a[n+s]>0) 
            {if(i+2-a[n+s]>max) max=i+2-a[n+s];}
            else a[n+s]=i+2;
        }
        return max;
    }
}
