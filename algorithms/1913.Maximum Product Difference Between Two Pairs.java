class Solution {
    public int maxProductDifference(int[] a) {
        Arrays.sort(a);
        int n=a.length;
        return a[n-1]*a[n-2]-a[0]*a[1];
    }
}
