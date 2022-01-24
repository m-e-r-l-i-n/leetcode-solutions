//Tamonash Chakraborty
//O((2^n)*(n^2))
class Solution {
    public int maximumGood(int[][] g) {
        int n=g.length,i,m=1<<n,ans=0;
        for(i=1;i<m;i++)
        {
            int j,k,cur=0;
            boolean ok=true;
            for(j=0;j<n && ok;j++)
            for(k=0;k<n && ok;k++)  //check all pairs
            if(k!=j)
            {
                int u=(i>>j)&1,v=(i>>k)&1;
                //2 cases where conflict can occur
                if(g[j][k]==0 && (u==1 && v==1)) ok=false;
                if(g[j][k]==1 && (u==1 && v==0)) ok=false;
            }
            if(!ok) continue;
            
            for(j=0;j<n;j++) cur+=(i>>j)&1;
            ans=Math.max(ans,cur);
        }
        return ans;
    }
}
