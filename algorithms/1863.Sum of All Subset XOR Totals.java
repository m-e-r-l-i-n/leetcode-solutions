class Solution {
    public int subsetXORSum(int[] a) {
        int n=a.length,m=1<<n,i,j,s=0;
        for(i=1;i<m;i++)
        {
            int x=0;
            for(j=0;j<n;j++)
            if(((i>>j)&1)==1) x^=a[j];
            s+=x;
        }
        return s;
    }
}
