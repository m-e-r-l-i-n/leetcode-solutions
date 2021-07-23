class Solution {
    public int partitionDisjoint(int[] a) 
    {
        int n=a.length,i,m[]=new int[n];
        m[n-1]=a[n-1];
        for(i=n-2;i>=0;i--) m[i]=Math.min(m[i+1],a[i]);
        
        int par=0,ma=0;
        for(i=0;i<n-1;i++)
        {
            ma=Math.max(ma,a[i]);
            par++;
            if(ma<=m[i+1]) break;
        }
        return par;
    }
}
