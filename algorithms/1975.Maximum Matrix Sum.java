class Solution {
    public long maxMatrixSum(int[][] a) {
        long ans=0;
        int i,j,min=Integer.MAX_VALUE,n=a.length,lo=0,z=0;
        for(i=0;i<n;i++)
        for(j=0;j<n;j++)
        {
            min=Math.min(min,Math.abs(a[i][j]));
            if(a[i][j]<0) 
            {
                ans-=a[i][j]; 
                lo++;
            }
            else if(a[i][j]==0) z++;
            else ans+=a[i][j];
        }
        
        if(lo%2==0 || z>0) return ans;
        return ans-2*min;
    }
}
