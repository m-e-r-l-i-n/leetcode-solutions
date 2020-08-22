class Solution {
    public boolean containsCycle(char[][] grid) {
        int n=grid.length,m=grid[0].length,i,j;
        boolean vis[][]=new boolean[n][m];
        boolean ans=false;
        for(i=0;i<n;i++)
        for(j=0;j<m;j++)
        if(!vis[i][j])
        {
            ans=isCycle(i,j,grid,vis,-1,-1);
            if(ans) return ans;
        }
        return ans;            
    }

    
    boolean isCycle(int x,int y,char a[][],boolean v[][],int px,int py) 
    { 
      
        v[x][y]=true; 
        int dx[]={-1,0,1,0 },dy[]={0,1,0,-1},i;  
        for(i=0;i<4;i++) 
        { 
            int nx=x+dx[i]; 
            int ny=y+dy[i]; 
  
            if(valid(nx,ny,a.length,a[0].length) && a[nx][ny]==a[x][y] && !(px==nx && py==ny))  
            { 
              
                if(v[nx][ny]) return true;
                else 
                { 
                    boolean check=isCycle(nx,ny,a,v,x,y);
                    if(check) return true;
                }
            } 
        } 
        return false; 
    } 
    
    boolean valid(int x,int y,int n,int m)
    {
        if(x>=0 && x<n && y>=0 && y<m) return true;
        return false;
    }
} 
