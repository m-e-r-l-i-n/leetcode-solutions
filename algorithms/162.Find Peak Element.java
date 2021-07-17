class Solution {
    public int findPeakElement(int[] a) {
        int l=0,r=a.length-1,ans,m;
        while(l<r)
        {
            m=(l+r)>>1;
            if(a[m]<a[m+1]) l=m+1;
            else r=m;
        }
        return l;
    }
}
