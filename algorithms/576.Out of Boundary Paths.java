class Solution {
    public int findPaths(int m, int n, int maxMove, int r, int c) 
    {
        int i,d[][]={{-1,0},{1,0},{0,1},{0,-1}},cur=1; 
        long ans=0,M=(int)1e9+7,v[][][]=new long[2][m][n];
        v[0][r][c]=1; 
        for(i=0;i<maxMove;i++)
        {
            int j,k;
            for(j=0;j<m;j++) 
            {
                ans=(ans+v[cur^1][j][0])%M;
                ans=(ans+v[cur^1][j][n-1])%M;
                Arrays.fill(v[cur][j],0);
            }
            for(j=0;j<n;j++) 
            {
                ans=(ans+v[cur^1][0][j])%M;
                ans=(ans+v[cur^1][m-1][j])%M;
            }
            
            for(j=0;j<m;j++)
            for(k=0;k<n;k++)
            for(int di[]:d)
            {
                int tx=j+di[0],ty=k+di[1];
                if(tx>=0 && tx<m && ty>=0 && ty<n)
                v[cur][tx][ty]=(v[cur][tx][ty]+v[cur^1][j][k])%M;
            }
            cur^=1;
        }
        return (int)ans;
    }
}
