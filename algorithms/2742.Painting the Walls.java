class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n=time.length,i,j,k,dp[]=new int[n+1],M=(int)1e9; 
        Arrays.fill(dp,M);
        dp[0]=0;
        
        for(i=0;i<n;i++)    
        {
            time[i]=Math.min(time[i],n);    //its pointless to take more time
            
            for(j=n;j>=0;j--)   //time taken for paid painter to paint
            dp[j]=Math.min(dp[j],dp[Math.max(j-time[i]-1,0)]+cost[i]);
        }
        return dp[n];
    }
}
