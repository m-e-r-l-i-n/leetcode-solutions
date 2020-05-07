class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0) return 0;
        int i,j,max=0,dp[][]=new int[matrix.length][matrix[0].length];
        for(i=0;i<matrix.length;i++)
        for(j=0;j<matrix[0].length;j++)
        {
            dp[i][j]=matrix[i][j]-'0';
            if(i!=0 && j!=0 && matrix[i][j]=='1')
                dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
            if(dp[i][j]>max) max=dp[i][j];
        }
        return max*max;
    }
}
