class Solution {
    public int numIslands(char[][] grid) 
    {
        int i,j,c=0;
        for(i=0;i<grid.length;i++)
        for(j=0;j<grid[0].length;j++)
            if(grid[i][j]=='1')
            {dfs(grid,i,j); c++;}
        return c;        
    }
    
    void dfs(char [][] grid,int r,int c)
    {
        if(grid[r][c]=='0') return;
        grid[r][c]='0';
        if(r+1<grid.length) dfs(grid,r+1,c);
        if(r-1>=0) dfs(grid,r-1,c);
        if(c+1<grid[0].length) dfs(grid,r,c+1);
        if(c-1>=0) dfs(grid,r,c-1);
    }
}
