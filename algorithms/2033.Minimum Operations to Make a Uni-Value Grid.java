//Tamonash Chakraborty
//O(nm)
class Solution {
    public int minOperations(int[][] g, int x) {
        int n=g.length,m=g[0].length,i,j,mod=g[0][0]%x,N=10000,c[]=new int[N+1];
        for(i=0;i<n;i++)
        for(j=0;j<m;j++)
        {
            if(g[i][j]%x!=mod) return -1;
        	c[g[i][j]/x]++;
        }
        
        int ans,r[]=new int[N+2],cn=0;
        for(i=N;i>=0;i--)	//moves to make larger into current
        {
            r[i]=r[i+1]+cn;
            cn+=c[i];
        }
        
        ans=r[0];
        int cost=0; cn=0;
        for(i=1;i<=N;i++)	//moves to make smaller than current+larger to current for all [1,10^4]
        {
            cn+=c[i-1];
            cost+=cn;
            ans=Math.min(ans,cost+r[i]);
        }
        return ans;
    }
}
