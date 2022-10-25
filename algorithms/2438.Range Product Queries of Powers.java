class Solution {
    public int[] productQueries(int n, int[][] queries) {
        ArrayList<Integer> powers=new ArrayList<>();
        int i,q=queries.length,ans[]=new int[q];
        for(i=0;i<30;i++)
        if(((n>>i)&1)==1) powers.add(1<<i);
        
        int sz=powers.size(),dp[][]=new int[sz][sz];
        for(i=0;i<sz;i++)
        {
            long v=1,M=(int)1e9+7;
            for(int j=i;j<sz;j++)
            {
                v=v*powers.get(j)%M;
                dp[i][j]=(int)v;
            }
        }
        
        for(i=0;i<q;i++) ans[i]=dp[queries[i][0]][queries[i][1]];
        return ans;
    }
}
