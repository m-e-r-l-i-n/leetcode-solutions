class Solution {
    public int[][] flipAndInvertImage(int[][] a) {
        int n=a.length,i,j;
        for(i=0;i<n;i++)
        {
            for(j=0;j<n/2;j++)
            {
                int t=a[i][n-j-1];
                a[i][n-j-1]=a[i][j];
                a[i][j]=t;
                a[i][j]^=1;
                a[i][n-j-1]^=1;
            }   
            if(n%2==1) a[i][n/2]^=1;
        }
        return a;
    }
}
