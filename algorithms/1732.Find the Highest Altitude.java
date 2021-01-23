class Solution {
    public int largestAltitude(int[] g) {
        int cur=0,max=0,i,n=g.length;
        for(i=0;i<n;i++)
        {
            cur+=g[i];
            max=Math.max(max,cur);
        }
        return max;
    }
}
