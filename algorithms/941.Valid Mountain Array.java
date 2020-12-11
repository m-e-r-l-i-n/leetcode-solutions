class Solution {
    public boolean validMountainArray(int[] a) 
    {
        if(a.length<3 || a[0]>a[1]) return false;
        int i,n=a.length;
        for(i=1;i<n-1;i++)
        if(a[i]<=a[i-1]) break;
        if(i==n-1 && a[i]>a[i-1]) return false;
        for(;i<n;i++)
        if(a[i]>=a[i-1]) return false;
        return true;
    }
}
