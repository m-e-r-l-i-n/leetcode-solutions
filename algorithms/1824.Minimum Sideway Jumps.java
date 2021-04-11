class Solution {
    public int minSideJumps(int[] o) {
        int n=o.length,dp[][]=new int[2][3],cur=1,i,j;
        boolean frog[][]=new boolean[2][3];
        frog[0][1]=true; dp[0][0]=dp[0][2]=(int)1e9;
        
        for(i=1;i<n;i++)
        {
            for(j=0;j<3;j++) {dp[cur][j]=(int)1e9; frog[cur][j]=false;}
            
            for(j=0;j<3;j++)
            for(int k=0;k<3;k++)
            if(o[i]!=j+1 && frog[cur^1][k])
            {
                if(k==j) 
                {
                    frog[cur][j]=true;
                    dp[cur][j]=Math.min(dp[cur][j],dp[cur^1][k]);
                }
                else
                {
                    int rem=4-(j+k);
                    if(o[i]!=k+1 || o[i-1]!=j+1) 
                    {
                        dp[cur][j]=Math.min(dp[cur][j],dp[cur^1][k]+1);
                        frog[cur][j]=true;
                    }
                    else if(o[i-1]!=rem && o[i]!=rem)
                    {
                        dp[cur][j]=Math.min(dp[cur][j],dp[cur^1][k]+2);
                        frog[cur][j]=true;
                    }
                }
            }
            
            cur^=1;
        }
        int ans=Integer.MAX_VALUE;
        for(i=0;i<3;i++) ans=Math.min(ans,dp[cur^1][i]);
        return ans;
    }
}
