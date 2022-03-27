//Tamonash Chakraborty
//O(numCoins*k)
class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int dp[][]=new int[2][k+1];
        int i,cur=1;
        Arrays.fill(dp[0],-1);
        dp[0][0]=0;
        
        for(List<Integer> pile:piles)  //iterate through all piles
        {
            int pre=0,sz=0;
            for(i=0;i<=k;i++) dp[cur][i]=dp[cur^1][i];  
            //there might be a case where we don't pick any value of this stack 
            for(int x:pile)
            {
                pre+=x; //prefix sum;
                sz++;
                for(i=sz;i<=k;i++)  //fill dp table in top down approach
                if(dp[cur^1][i-sz]!=-1) dp[cur][i]=Math.max(dp[cur][i],dp[cur^1][i-sz]+pre);    
            }
            cur^=1;
        }
        return dp[cur^1][k];
    }
}
