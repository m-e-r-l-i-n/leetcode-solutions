class Solution {
    public boolean canChoose(int[][] g, int[] a) 
    {
        int j=0,i,n=a.length,m=g.length;
        for(i=0;i<n;i++)
        if(a[i]==g[j][0])
        {
            boolean pos=true;
            int k=0;
            for(;k<g[j].length && i+k<n;k++)
            if(g[j][k]!=a[i+k]) {pos=false; break;}
            if(k<g[j].length) pos=false;
            if(pos) 
            {
                j++;
                i+=k;
                i--;
            }
            if(j==m) break;
        }
        return j==m;
    }
}
