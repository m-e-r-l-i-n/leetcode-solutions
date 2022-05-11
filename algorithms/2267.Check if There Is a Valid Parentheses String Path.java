//Tamonash Chakraborty
//O(m*n*(m+n))
class Solution {
    public boolean hasValidPath(char[][] grid) {
        if(grid[0][0]==')') return false;   //not possible at all
        int n=grid.length,m=grid[0].length,i,j;
        boolean vis[][][]=new boolean[n][m][n+m]; //+ - should ultimately result in 0
        vis[0][0][1]=true;
        
        for(i=0;i<n;i++)
        for(j=0;j<m;j++)
        if(i==0 && j==0) continue;  //we have fixed base cases
        else
        {
            int add=1,k;    //( will contribute +1 and ) -1
            if(grid[i][j]==')') add=-1;
            
            for(k=0;k<n+m;k++)  //check which values can be obtained
            if(k+add>=0 && k+add<n+m)
            {
                if(j-1>=0) vis[i][j][k+add]|=vis[i][j-1][k];  //from left
                if(i-1>=0) vis[i][j][k+add]|=vis[i-1][j][k];    //from top
            }    
        }
        return vis[n-1][m-1][0];
    }
}
