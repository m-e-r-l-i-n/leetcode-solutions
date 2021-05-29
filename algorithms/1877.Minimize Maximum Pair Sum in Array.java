class Solution {
    public int minPairSum(int[] a) {
        Arrays.sort(a);
        int max=0,i,n=a.length;
        for(i=0;i<n/2;i++)
        max=Math.max(max,a[i]+a[n-i-1]);
        return max;
    }
}
