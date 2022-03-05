//Tamonash Chakraborty
//O(n^2)
class Solution {
    public int houseOfCards(int n) {
        dp=new int[n+1][n+1];
        for(int i=0;i<=n;i++) Arrays.fill(dp[i],-1);
        return countWays(n,n);  //n is like an upper bound for the ground (level below lowest row) 
    }
    
    int dp[][];
    int countWays(int cards,int lower)  //recursive DP+memo
    {
        if(dp[cards][lower]!=-1) return dp[cards][lower];
        if(cards==0) return 1;  //we completed a house
        
        int tri=1,req; dp[cards][lower]=0;
        while(tri<lower)    //only these many cards can be used here
        {
            req=tri*2;
            req+=tri-1; //number of cards required
            //count ways we can use (cards-req) cards and tri triangles as topmost current row
            if(req<=cards) dp[cards][lower]+=countWays(cards-req,tri);  
            else break;
            tri++;
        }
        return dp[cards][lower];
    }
}
