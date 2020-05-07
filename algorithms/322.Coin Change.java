class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount==0) return 0;
        int i, j,max=amount+1,dp[]=new int[max];
        Arrays.fill(dp,max);
        dp[0]=0;
        for(i=1;i<=amount;i++)
        for(j=0;j<coins.length;j++)
            if(coins[j]<=i) dp[i]=Math.min(dp[i], dp[i-coins[j]]+1);
        if(dp[amount]>amount) amount=-1;
        else amount=dp[amount];
        return amount;
    }
}
