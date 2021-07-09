class Solution {
    public int[][] matrixReshape(int[][] g, int r, int c) {
        int a[][]=new int[r][c],i,j,x=0,y=0,n=g.length,m=g[0].length;
        if(r*c!=n*m) return g;
        for(i=0;i<r;i++)
        for(j=0;j<c;j++)
        {
            a[i][j]=g[x][y++];
            if(y==m) {y=0; x++;}
        }
        return a;
    }
}
