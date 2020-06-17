class Solution {
    public void solve(char[][] b) 
    {
        if(b.length<3 || b[0].length<3) return;
        int i,j,n=b.length,m=b[0].length;
        for(i=0;i<n;i++)
        {
            if(b[i][0]=='O') dfs(b,i,0);
            if(b[i][m-1]=='O') dfs(b,i,m-1);
        }
        for(i=1;i<m-1;i++)
        {
            if(b[0][i]=='O') dfs(b,0,i);
            if(b[n-1][i]=='O') dfs(b,n-1,i);
        }
        for(i=0;i<n;i++)
        for(j=0;j<m;j++)
        {
            if(b[i][j]=='O') b[i][j]='X';
            if(b[i][j]=='*') b[i][j]='O';
        }           
    }
    
    void dfs(char b[][],int r,int c)
    {
        if(r<0 || r>=b.length || c<0 || c>=b[0].length || b[r][c]!='O') return;
        b[r][c]='*';
        dfs(b,r+1,c);
        dfs(b,r-1,c);
        dfs(b,r,c+1);
        dfs(b,r,c-1);
    }
}
