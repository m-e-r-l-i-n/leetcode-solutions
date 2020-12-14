class Solution {
    public int[] getSumAbsoluteDifferences(int[] a) {
        int i,n=a.length,r[]=new int[n+1];
        for(i=n-1;i>=0;i--)
        r[i]=r[i+1]+a[i];
        
        int ans[]=new int[n],left=0;
        for(i=0;i<n;i++)
        {
            left+=a[i];
            ans[i]=a[i]*(i+1)-left+r[i]-a[i]*(n-i);    
        }
        return ans;
    }
}
