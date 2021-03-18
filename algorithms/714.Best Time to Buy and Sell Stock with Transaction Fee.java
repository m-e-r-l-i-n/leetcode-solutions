class Solution {
    public int maxProfit(int[] a, int fee) {
        int i,n=a.length,h[]=new int[n],nh[]=new int[n];
        h[0]=-a[0];
        for(i=1;i<n;i++)
        {
            h[i]=Math.max(h[i-1],nh[i-1]-a[i]);
            nh[i]=Math.max(nh[i-1],h[i-1]-fee+a[i]);
        }
        return nh[n-1];
    }
}
