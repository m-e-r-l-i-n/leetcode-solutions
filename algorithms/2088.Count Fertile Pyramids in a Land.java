//Tamonash Chakraborty
//O(nm)
class Solution 
{
    public int countPyramids(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        int g2[][]=new int[n][m],i,j;
        //just invert rows of the grid
        for(i=n-1;i>=0;i--)
        for(j=0;j<m;j++) g2[n-1-i][j]=grid[i][j];
        
        int ans=count(grid);
        ans+=count(g2);
        return ans;
    }
    
    int count(int g[][])   //count pyramids(upright) in a grid
    {
        int n=g.length,m=g[0].length,i,j,ded=0;
        int ans=0;
        int l[][]=new int[n+5][m+5],r[][]=new int[n+5][m+5],dp[][]=new int[n+5][m+5];
        
        for(i=1;i<=n;i++)
        for(j=1;j<=m;j++)
        if(g[i-1][j-1]==1)
        {
            l[i][j]=l[i][j-1]+1;    //maximum extendable to the left
            ded++;  //single blocks
        }
        
        for(i=1;i<=n;i++)
        for(j=m;j>0;j--)
        if(g[i-1][j-1]==1)
        r[i][j]=r[i][j+1]+1;    //maximum extendable to the right
        
        for(i=1;i<=n;i++)
        for(j=1;j<=m;j++)
        {
            dp[i][j]=Math.min(dp[i-1][j], Math.min(l[i][j]-1,r[i][j]-1))+1; //form dp using previous, left and right ranges
            ans=ans+dp[i][j];
        }
        
        ans-=ded;
        return ans;
    }
}
