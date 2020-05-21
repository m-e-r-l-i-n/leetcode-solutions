class Solution {
    public int countSquares(int[][] a) {
        int c=0,n=a.length,m=a[0].length,i,j,s[][]=new int[n][m];
        for(i=0;i<n;i++)
        for(j=0;j<m;j++)
        {
            if(i==0||j==0) s[i][j]=a[i][j];
            else if(a[i][j]==1) s[i][j]=Math.min(s[i-1][j],Math.min(s[i-1][j-1],s[i][j-1]))+1;
            c+=s[i][j];
        }    
        return c;
    }
}
