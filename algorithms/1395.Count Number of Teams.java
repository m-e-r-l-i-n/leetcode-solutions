class Solution {
    public int numTeams(int[] r) {
        int n=r.length,i,j,k,c=0;
        for(i=0;i<n-2;i++)
            for(j=i+1;j<n-1;j++)
                for(k=j+1;k<n;k++)
                    if((r[i]>r[j] && r[j]>r[k]) || (r[i]<r[j] && r[j]<r[k])) c++;
        return c;
    }
}
