//Tamonash Chakraborty
//O(nm)
class Solution {
    public boolean possibleToStamp(int[][] grid, int h, int w) 
    {
        int n=grid.length,m=grid[0].length,i,j;
        int g[][]=new int[n+2][m+2],dp[][]=new int[n+2][m+2];
        for(i=0;i<n;i++) 
        for(j=0;j<m;j++)    //prefix sum of matrix
        dp[i+1][j+1]=grid[i][j]+dp[i][j+1]+dp[i+1][j]-dp[i][j];
        
        for(i=1;i<=n;i++)
        for(j=1;j<=m;j++)
        {
            if(j+w>m+1 || i+h>n+1) continue;
            //mark areas where we can paste a stamp
            int sum=dp[i+h-1][j+w-1]-dp[i-1][j+w-1]-dp[i+h-1][j-1]+dp[i-1][j-1];
            if(sum==0)
            {
                g[i][j]+=1; g[i+h][j+w]+=1;
                g[i+h][j]-=1; g[i][j+w]-=1;
            }
        }
        
        for(j=1;j<=m;j++)
        for(i=1;i<=n;i++) g[i][j]+=g[i-1][j];
        
        for(i=1;i<=n;i++)
        for(j=1;j<=m;j++)
        {
            g[i][j]+=g[i][j-1];
            if(g[i][j]==0 && grid[i-1][j-1]==0) return false;
        }
        return true;
    }
}
