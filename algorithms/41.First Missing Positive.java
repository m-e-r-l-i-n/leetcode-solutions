class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length,a[]=new int[n+1],i;
        for(i=1;i<=n;i++) a[i]=nums[i-1];
        
        for(i=1;i<=n;i++)
        if(a[i]<=0 || a[i]>n) a[i]=0;
        else if(a[i]!=i)
        {
            int from=i,to=a[i];
            if(a[to]!=to)
            {
                a[from]=a[from]^a[to]^(a[to]=a[from]);
                i--;
            }
            else a[i]=0;
        }
        
        for(i=1;i<=n;i++)
        if(a[i]==0) return i;
        return i;
    }
}
