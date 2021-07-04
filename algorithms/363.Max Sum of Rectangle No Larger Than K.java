class Solution {
    public int maxSumSubmatrix(int[][] a, int k) 
    {
        int n=a.length,m=a[0].length,ans=Integer.MIN_VALUE,i,j,l,s[]=new int[n];
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++) s[j]=0;
            for(j=i;j<m;j++)
            {
                for(l=0;l<n;l++) s[l]+=a[l][j];
                ans=Math.max(ans,arraysum(s,k));
            }    
        }
        return ans;
    }
    
    int arraysum(int a[],int k)
    {
        TreeSet<Integer> t=new TreeSet<>();
        t.add(0); int s=0,ans=Integer.MIN_VALUE;
        for(int x:a)
        {
            s+=x;
            Integer i=t.ceiling(s-k);
            if(i!=null) ans=Math.max(ans,s-i);
            t.add(s);
        }
        return ans;
    }
}
