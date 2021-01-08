class Solution {
    public int findKthPositive(int[] a, int k) {
        int i,n=a.length,prev=0;
        for(i=0;i<n;i++)
        if(a[i]-prev>k) return prev+k;
        else
        {
            k-=a[i]-prev-1;
            prev=a[i];
        }
        return prev+k;
    }
}
