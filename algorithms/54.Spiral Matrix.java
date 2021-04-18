class Solution {
    public List<Integer> spiralOrder(int[][] a) {
        List<Integer> ans=new ArrayList<>();
        int n=a.length,m=a[0].length,l=0,r=m-1,u=0,d=n-1,i; 
        boolean vis[][]=new boolean[n][m];
        while(l<=r && u<=d)
        {
            for(i=l;i<=r;i++)
            if(!vis[u][i])
            {
                ans.add(a[u][i]);
                vis[u][i]=true;
            }
            for(i=u+1;i<=d;i++)
            if(!vis[i][r])
            {
                ans.add(a[i][r]);
                vis[i][r]=true;
            }
            for(i=r-1;i>=l;i--)
            if(!vis[d][i])
            {
                ans.add(a[d][i]);
                vis[d][i]=true;
            }
            for(i=d-1;i>u;i--)
            if(!vis[i][l])
            {
                ans.add(a[i][l]);
                vis[i][l]=true;
            }
            l++; u++; d--; r--;
        }
        return ans;
    }
}
