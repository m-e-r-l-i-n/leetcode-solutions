class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        int r=100,i,j;
        double dp[][]=new double[r][r];
        dp[0][0]=poured;
        for(i=0;i<query_row;i++)
        for(j=0;j<=i;j++)
        if(dp[i][j]>1) 
        {
            dp[i+1][j]+=(dp[i][j]-1)/2;
            dp[i+1][j+1]+=(dp[i][j]-1)/2;
            dp[i][j]=1;
        }
        return Math.min(1,dp[query_row][query_glass]);
    }
}
