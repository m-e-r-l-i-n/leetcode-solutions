class Solution {
    public String getSmallestString(int n, int k) {
        int a[]=new int[n],i;
        k-=n;
        for(i=n-1;i>=0;i--)
        {
            if(k==0) break;
            int r=Math.min(k,25);
            a[i]+=r;
            k-=r;
        }
        StringBuilder sb=new StringBuilder();
        for(i=0;i<n;i++)
        sb.append((char)('a'+a[i]));
        return sb.toString();
    }
}
