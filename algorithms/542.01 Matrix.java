class Solution {
    public int[][] updateMatrix(int[][] a) {
        int n=a.length,m=a[0].length,i,j,ans[][]=new int[n][m],d[][]={{-1,0},{0,1},{1,0},{0,-1}};
        Queue<Integer> q=new LinkedList<>();
        for(i=0;i<n;i++)
        for(j=0;j<m;j++)
        if(a[i][j]==0)
        {
            q.add(i); q.add(j);
        }
        else ans[i][j]=-1;
        
        while(!q.isEmpty())
        {
            int px=q.poll(),py=q.poll();
            for(int di[]:d)
            {
                int tx=px+di[0],ty=py+di[1];
                if(tx<0 || tx>=n || ty<0 || ty>=m || ans[tx][ty]!=-1) continue;
                ans[tx][ty]=ans[px][py]+1;
                q.add(tx); q.add(ty);
            }
        }
        return ans;
    }
}
