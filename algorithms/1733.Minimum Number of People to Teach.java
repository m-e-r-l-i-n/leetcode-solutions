class Solution {
    public int minimumTeachings(int n, int[][] l, int[][] f) 
    {
        int m=l.length,i,k,j;
        boolean ln[][]=new boolean[m][n+1];
        for(i=0;i<m;i++) 
        for(int x:l[i]) ln[i][x]=true;
        
        Set<Integer> set=new HashSet<>();
        for(i=0;i<f.length;i++)
        {
            int u=f[i][0]-1,v=f[i][1]-1;
            boolean fr=false;
            for(j=1;j<=n;j++)
            if(ln[u][j] && ln[v][j]) {fr=true; break;}
            
            if(!fr)
            {
                set.add(u);
                set.add(v);
            }
        }
        int ans=Integer.MAX_VALUE;
        for(i=1;i<=n;i++)
        {
            int tot=0;
            for(int x:set)
            if(!ln[x][i]) tot++;
            ans=Math.min(ans,tot);
        }
        return ans;
    }
}
