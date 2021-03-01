class Solution {
    public int findUnsortedSubarray(int[] a) {
        int l=-1,r=-2,i,n=a.length,min=a[n-1],max=a[0];
        if(n==1) return 0;
        for(i=1;i<n;i++)
        {
            min=Math.min(min,a[n-i-1]);
            max=Math.max(max,a[i]);
            if(a[i]<max) r=i;
            if(a[n-i-1]>min) l=n-i-1;
        }
        return r-l+1;
    }
}
