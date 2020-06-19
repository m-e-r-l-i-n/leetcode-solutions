class Solution {
    public int hIndex(int[] c) {
        int l=0,r=c.length-1,mid;
        while(l<=r)
        {
            mid=(l+r)/2;
            if(c[mid]>=(c.length-mid)) r=mid-1;
            else l=mid+1;
        }
        return c.length-l;
    }
}
