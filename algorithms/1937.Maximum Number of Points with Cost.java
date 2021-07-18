class Solution {
    public long maxPoints(int[][] a) 
    {
        int i,j,n=a.length,m=a[0].length;
        long dp[][]=new long[n][m];
        for(i=0;i<m;i++) dp[0][i]=a[0][i];
        for(i=1;i<n;i++)
        {
            PriorityQueue<Long> pq=new PriorityQueue<>(Collections.reverseOrder());
            for(j=0;j<m;j++)
            {
                pq.add(dp[i-1][j]+j);
                dp[i][j]=pq.peek()-j;
            }
            pq=new PriorityQueue<>(Collections.reverseOrder());
            for(j=m-1;j>=0;j--)
            {
                pq.add(dp[i-1][j]-j);
                dp[i][j]=Math.max(dp[i][j],pq.peek()+j)+a[i][j];
            }
        }
        
        long ans=Long.MIN_VALUE;
        for(i=0;i<m;i++) ans=Math.max(ans,dp[n-1][i]);
        return ans;
    }
}
