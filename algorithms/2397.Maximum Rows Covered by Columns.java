//O(m*n*2^n)
class Solution {
    public int maximumRows(int[][] mat, int cols) {
        int m=mat.length,n=mat[0].length,i,ans=0;
        for(i=1;i<(1<<n);i++)   //all subsets
        {
            int bits=0,j;
            for(j=0;j<n;j++)
            bits+=(i>>j)&1;
            if(bits!=cols) continue;    //exact cols columns
            
            int rows=0,k;
            for(j=0;j<m;j++)    //check if the row is covered
            {
                for(k=0;k<n;k++)
                if(mat[j][k]==1 && ((i>>k)&1)!=1) break;
                if(k==n) rows++;
            }
            ans=Math.max(ans,rows);
        }
        return ans;
    }
}
