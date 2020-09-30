class Solution {
    public int firstMissingPositive(int[] a) {
        int i,n=a.length;
        for(i=0;i<n;i++)
        while(a[i]>0 && a[i]<=n && a[a[i]-1]!=a[i])
        a[i]=a[i]^a[a[i]-1]^(a[a[i]-1]=a[i]);
        
        for(i=0;i<n;i++)
        if(a[i]!=i+1) return i+1;
        return n+1;
    }
}
