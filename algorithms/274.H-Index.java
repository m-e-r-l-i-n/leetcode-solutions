class Solution {
    public int hIndex(int[] c) {
        //use bucket sort
        int i,n=c.length,t=0,a[]=new int[n+1];
        for(i=0;i<n;i++)
        {
            if(c[i]>n) a[n]++;
            else a[c[i]]++;
        }  
        for(i=n;i>=0;i--)
        {
            t+=a[i];
            if(t>=i) return i;
        }
        return 0;
    }
}
