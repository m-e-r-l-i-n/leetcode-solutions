class Solution {
    public int getWinner(int[] a, int k) {
        int cmax=Math.max(a[0],a[1]),cc=1,i,n=a.length;
        for(i=2;i<n;i++)
        {
            if(cc==k) return cmax;
            if(a[i]>cmax)
            {
                cmax=a[i];
                cc=1;
            }
            else cc++;
        }
        return cmax;
    }
}
