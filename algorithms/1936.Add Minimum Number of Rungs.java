class Solution {
    public int addRungs(int[] a, int d) 
    {
        int i,l=0,ans=0;
        for(i=0;i<a.length;i++)
        {
            int c=a[i]-l;
            c=c/d+(c%d==0?0:1);
            c--;
            ans+=c;
            l=a[i];
        }
        return ans;
    }
}
