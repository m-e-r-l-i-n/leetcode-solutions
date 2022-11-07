class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n=str1.length(),m=str2.length(),i,j,dp[][]=new int[n+1][m+1],prev[][][]=new int[n+1][m+1][2];
        prev[0][0][0]=prev[0][0][1]=-1;
        for(i=1;i<=n;i++)
        for(j=1;j<=m;j++)
        {
            int add=0;
            if(str1.charAt(i-1)==str2.charAt(j-1)) add++;
            dp[i][j]=dp[i-1][j-1]+add;
            prev[i][j][0]=i-1; prev[i][j][1]=j-1;
            
            if(dp[i-1][j]>dp[i][j])
            {
                dp[i][j]=dp[i-1][j];
                prev[i][j][0]=i-1; prev[i][j][1]=j;
            }
            if(dp[i][j-1]>dp[i][j])
            {
                dp[i][j]=dp[i][j-1];
                prev[i][j][0]=i; prev[i][j][1]=j-1;
            }
        }
        
        boolean vis[]=new boolean[n];
        i=n; j=m;
        while(i>0 && j>0)
        {
            if(str1.charAt(i-1)==str2.charAt(j-1)) vis[i-1]=true;
            int ni=prev[i][j][0],nj=prev[i][j][1];
            i=ni; j=nj;
        }
        
        j=0; i=0;
        StringBuilder sb=new StringBuilder();
        while(i<n && j<m)
        {
            if(!vis[i]) 
            {
                sb.append(str1.charAt(i++));
                continue;    
            }
            
            while(j<m && str2.charAt(j)!=str1.charAt(i)) sb.append(str2.charAt(j++));
            j++; sb.append(str1.charAt(i++));
        }
        while(i<n) sb.append(str1.charAt(i++));
        while(j<m) sb.append(str2.charAt(j++));
        return sb.toString();
    }
}
