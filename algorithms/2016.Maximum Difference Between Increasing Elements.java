class Solution {
    public int maximumDifference(int[] a) {
        int i,j,max=-1,n=a.length,min=a[0];
        for(i=1;i<n;i++)
        {
            if(a[i]>min) max=Math.max(max,a[i]-min);
            min=Math.min(min,a[i]);
        }
        return max;
    }
}
