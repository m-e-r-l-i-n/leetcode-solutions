class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length,a[]=new int[m+n];
        int i=0,j=0,t=0;
        while(i<m && j<n)
        if(nums1[i]<=nums2[j])
            a[t++]=nums1[i++]; 
        else a[t++]=nums2[j++];        
        
        while(i<m)
            a[t++]=nums1[i++];
        while(j<n)
            a[t++]=nums2[j++];
        
        if((n+m)%2==1) return a[(n+m)/2];
        else return 1.0*(a[(n+m)/2]+a[(n+m)/2-1])/2;
        
    }
}
