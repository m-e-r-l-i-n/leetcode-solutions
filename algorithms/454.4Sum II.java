class Solution {
    public int fourSumCount(int[] a, int[] b, int[] c, int[] d) 
    {
        int n=a.length,m=b.length,i,j;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(i=0;i<n;i++)
        for(j=0;j<m;j++)
        hm.put(a[i]+b[j],hm.getOrDefault(a[i]+b[j],0)+1);
        
        int ans=0; n=c.length; m=d.length;
        for(i=0;i<n;i++)
        for(j=0;j<m;j++)
        ans+=hm.getOrDefault(-(c[i]+d[j]),0);
        return ans;
    }
}
