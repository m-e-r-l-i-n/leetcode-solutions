class Solution {
    public int cherryPickup(int[][] g) 
    {
        int n=g.length,m=g[0].length;
        int dp[][][]=new int[n][m][m],r,c1,c2;
        for(r=n-1;r>=0; r--) 
        for(c1=0;c1<m;c1++) 
        for(c2=0;c2<m;c2++) 
        {
            int val=(c1==c2) ? g[r][c1] : g[r][c1]+g[r][c2];
            if(r==n-1) {dp[r][c1][c2]=val; continue;}
            int next=0,i,j;
            for(i=-1; i<=1;i++) 
            for(j=-1;j<=1;j++) 
            {
                int c1_n=c1+i,c2_n=c2+j;
                if(c1_n>=0 && c1_n<m && c2_n>=0 && c2_n<m)
                    next=Math.max(next,dp[r+1][c1_n][c2_n]);
            }
            dp[r][c1][c2]=val+next;
        }
        return dp[0][0][m-1];
    }
}
