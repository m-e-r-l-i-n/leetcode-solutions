class Solution {
    public int peakIndexInMountainArray(int[] a) {
        int l=0,r=a.length,mid;
        while(l<=r)
        {
            mid=l+(r-l)/2;
            if(a[mid]>a[mid+1] && a[mid]>a[mid-1]) return mid;
            if(a[mid]<a[mid+1]) l=mid+1;
            else if(a[mid]>a[mid+1]) r=mid-1;
        }
        return l;
    }
}
