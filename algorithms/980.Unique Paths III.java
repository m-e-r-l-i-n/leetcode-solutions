class Solution {
    public int uniquePathsIII(int[][] g) 
    {
        int x=0,y=0,e=0,i,j;
        for(i=0;i<g.length;i++)
        for(j=0;j<g[0].length;j++)
        if(g[i][j]==0) e++;
        else if(g[i][j]==1)
        {x=i;y=j;}
        return dfs(g,x,y,-1,e);
    }
    
    int dfs(int[][] g,int i,int j,int c,int need)
    {
        if(i<0 || i==g.length || j<0 || j==g[0].length || g[i][j]==-1) return 0;
        if(g[i][j]==2)
        {
            if(c==need) return 1;
            else return 0;
        }
        
        g[i][j]=-1;
        int t=dfs(g,i-1,j,c+1,need);
        t+=dfs(g,i,j+1,c+1,need);
        t+=dfs(g,i+1,j,c+1,need);
        t+=dfs(g,i,j-1,c+1,need);
        g[i][j]=0;
        return t;
    }
}
