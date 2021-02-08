class Solution {
    public boolean check(int[] nums) {
        int n=nums.length,a[]=new int[2*n],i;
        for(i=0;i<n;i++)
        {
            a[i]=nums[i];
            a[n+i]=nums[i];
        }
        
        for(i=0;i<n;i++)
        if(sorted(a,i,i+n)) return true;
        return false;
    }
    
    boolean sorted(int a[],int s,int e)
    {
        for(int i=s+1;i<e;i++)
        if(a[i]<a[i-1]) return false;
        return true;
    }
}
