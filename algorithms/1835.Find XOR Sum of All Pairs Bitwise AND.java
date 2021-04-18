class Solution {
    public int getXORSum(int[] a1, int[] a2) {
        int c[]=new int[32],n=a1.length,m=a2.length,i,j;
        for(i=0;i<m;i++)
        for(j=0;j<32;j++)
        if(((a2[i]>>j)&1)==1) c[j]++;    
        
        int x[]=new int[32],ans=0;
        for(i=0;i<n;i++)
        for(j=0;j<32;j++)
        if(((a1[i]>>j)&1)==1) x[j]+=c[j];    
        
        for(i=0;i<32;i++)
        if(x[i]%2==1) ans|=1<<i;
        return ans;
    }
}
