class Solution {
    public int[] rearrangeArray(int[] a) {
        Arrays.sort(a);
        int n=a.length,i,j=n-1,ans[]=new int[n];
        for(i=0;i<n;i+=2) ans[i]=a[j--];
        for(i=1;i<n;i+=2) ans[i]=a[j--];
        return ans;
    }
}
