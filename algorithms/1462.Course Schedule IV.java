class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] pre, int[][] q) {
        int i,j,k; boolean a[][]=new boolean[n][n];
        for(i=0;i<pre.length;i++)
        a[pre[i][0]][pre[i][1]]=true;
        
        for(k=0;k<n;k++)    //floyd-warshall algorithm
        for(i=0;i<n;i++)
        for(j=0;j<n;j++)
        a[i][j]=a[i][j] || a[i][k] && a[k][j];
        
        List<Boolean> l=new ArrayList<>();
        for(i=0;i<q.length;i++)
        l.add(a[q[i][0]][q[i][1]]);
        return l;
    }
}
