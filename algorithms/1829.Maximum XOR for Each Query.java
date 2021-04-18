class Solution {
    public int[] getMaximumXor(int[] a, int b) 
    {
        int n=a.length,i,x=0,ans[]=new int[n];
        for(i=0;i<n;i++)
        x^=a[i];
        
        for(i=n-1;i>=0;i--)
        {
            int j;
            for(j=0;j<b;j++)
            if(((x>>j)&1)==0) ans[n-1-i]|=1<<j;
            x^=a[i];
        }
        return ans;
    }
}
