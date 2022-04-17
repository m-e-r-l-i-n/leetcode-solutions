class Solution {
    public int maxTrailingZeros(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        int dp[][][][]=new int[4][n][m][2],i,j,c[][][]=new int[n][m][2];
        
        //left and right of cells
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                int x=grid[i][j];
                while(x%2==0)
                {
                    x/=2;
                    c[i][j][0]++;
                }
                while(x%5==0)
                {
                    x/=5;
                    c[i][j][1]++;
                }
                
                for(x=0;x<2;x++)
                {
                    dp[0][i][j][x]=c[i][j][x];
                    if(j>0) dp[0][i][j][x]+=dp[0][i][j-1][x];
                }
            }
            
            for(j=m-1;j>=0;j--)
            for(int x=0;x<2;x++)
            {
                dp[1][i][j][x]=c[i][j][x];
                if(j<m-1) dp[1][i][j][x]+=dp[1][i][j+1][x];
            }
        }
        
        //up and down cells
        for(i=0;i<m;i++)
        {
            for(j=0;j<n-1;j++)
            for(int x=0;x<2;x++)
            {
                dp[2][j][i][x]=c[j][i][x];
                if(j>0) dp[2][j][i][x]+=dp[2][j-1][i][x];
            }
            
            for(j=n-1;j>=0;j--)
            for(int x=0;x<2;x++)
            {
                dp[3][j][i][x]=c[j][i][x];
                if(j<n-1) dp[3][j][i][x]+=dp[3][j+1][i][x];
            }
        }
        
        int ans=0;
        for(i=0;i<n;i++)
        for(j=0;j<m;j++)
        {
            if(i-1>=0)  
            {
                // ┘ path
                ans=Math.max(ans,Math.min(dp[2][i-1][j][0]+dp[0][i][j][0],dp[2][i-1][j][1]+dp[0][i][j][1]));
                //L path
                ans=Math.max(ans,Math.min(dp[2][i-1][j][0]+dp[1][i][j][0],dp[2][i-1][j][1]+dp[1][i][j][1]));
            }
            if(i+1<n)   
            {
                // ┐ path
                ans=Math.max(ans,Math.min(dp[3][i+1][j][0]+dp[0][i][j][0],dp[3][i+1][j][1]+dp[0][i][j][1])); 
                //┎ path
                ans=Math.max(ans,Math.min(dp[3][i+1][j][0]+dp[1][i][j][0],dp[3][i+1][j][1]+dp[1][i][j][1]));
            }
            
            for(int x=0;x<4;x++) ans=Math.max(ans,Math.min(dp[x][i][j][0],dp[x][i][j][1])); //no turn
        }
        return ans;
    }
}
