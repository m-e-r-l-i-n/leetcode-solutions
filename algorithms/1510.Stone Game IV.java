class Solution {
    Boolean dp[]=new Boolean[100001];
    public boolean winnerSquareGame(int n) {
        if(n==0) return false;
        if(dp[n]!=null) return dp[n];
        boolean w=false;
        for(int i=1; i*i<=n; i++)
        if(!winnerSquareGame(n-i*i)) 
        {
            w=true;
            break;           
        }
        return dp[n]=w;
    }
}
