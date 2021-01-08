class Solution {
    public int regionsBySlashes(String[] grid) {
        int n=grid.length,i,j;
        boolean g[][]=new boolean[3*n][3*n];
        for(i=0;i<n;i++)
        for(j=0;j<n;j++)
        if(grid[i].charAt(j)=='/') g[i*3][j*3+2]=g[i*3+1][j*3+1]=g[i*3+2][j*3]=true;
        else if(grid[i].charAt(j)=='\\') g[i*3][j*3]=g[i*3+1][j*3+1]=g[i*3+2][j*3+2]=true;
        
        int ans=0;
        for(i=0;i<3*n;i++)
        for(j=0;j<3*n;j++)
        if(!g[i][j])
        {
            ans++;
            fill(g,i,j,3*n);
        }
        return ans;
    }
    
    void fill(boolean g[][],int i,int j,int n)
    {
        if(i<0 || j<0 || i>=n || j>=n || g[i][j]) return;
        g[i][j]=true;
        fill(g,i-1,j,n);
        fill(g,i+1,j,n);
        fill(g,i,j-1,n);
        fill(g,i,j+1,n);
    }
}
