class Solution {
    public int removeCoveredIntervals(int[][] inter) {
        int n=inter.length;
        if(n<=1) return n;
        Arrays.sort(inter, (a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int c=1,i,prev[]=inter[0];
        for(i=1;i<n;i++)
        {
            int[] next=inter[i];
            if(prev[0]<=next[0] && prev[1]>=next[1]) continue;
            prev=next;
            c++;
        }
        return c;
    }
}
