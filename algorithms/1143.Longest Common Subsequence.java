class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length(),m=text2.length(),i,j,a[][]=new int[n+1][m+1];
        for(i=0;i<=n;i++)
        for(j=0;j<=m;j++)
        {
            if(i==0 || j==0) a[i][j]=0;
            else if(text1.charAt(i-1)==text2.charAt(j-1)) a[i][j]=a[i-1][j-1]+1;
            else a[i][j]=Math.max(a[i][j-1],a[i-1][j]);
        }
        return a[n][m];
    }
}
