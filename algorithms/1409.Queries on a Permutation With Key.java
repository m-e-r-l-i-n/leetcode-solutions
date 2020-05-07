class Solution {
    public int[] processQueries(int[] queries, int m) {
        int n=queries.length,a[]=new int[n],i,j,k,per[]=new int[m];
        for(i=1;i<=m;i++) per[i-1]=i;
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            if(per[j]==queries[i])
            {
                a[i]=j;
                for(k=j;k>0;k--) per[k]=per[k-1];
                per[0]=queries[i];
                break;
            }
        }
        return a;
    }
}
