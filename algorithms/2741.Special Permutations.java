class Solution {
    public int specialPerm(int[] nums) {
        int n=nums.length,mx=1<<n,i,j,l,cur=1,M=(int)1e9+7;
        HashMap<Integer,Integer> dp[][]=new HashMap[2][n];
        for(i=0;i<2;i++)
        for(j=0;j<n;j++) dp[i][j]=new HashMap<>();
        
        for(i=0;i<n;i++) dp[0][i].put(1<<i,1);
        for(i=1;i<n;i++)
        {
            for(j=0;j<n;j++) dp[cur][j].clear();
            
            for(j=0;j<n;j++)
            for(l=0;l<n;l++)    
            if(l!=j && (nums[j]%nums[l]==0 || nums[l]%nums[j]==0))
            for(int k:dp[cur^1][l].keySet())
            if(((k>>j)&1)==0) 
            {
                int key=k|(1<<j);
                dp[cur][j].put(key,(dp[cur][j].getOrDefault(key,0)+dp[cur^1][l].get(k))%M);
            }
            
            cur^=1;
        }
        
        int ans=0;
        for(i=0;i<n;i++)
        ans=(ans+dp[cur^1][i].getOrDefault(mx-1,0))%M;
        return ans;
    }
}
