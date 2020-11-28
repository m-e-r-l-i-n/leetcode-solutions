class Solution {
    public int jump(int[] a)
    {
        int i,ans=0,cur=0,max=0;
        for(i=0;i<a.length-1; i++)
        {
            max=Math.max(max,i+a[i]);
            if(i==cur)
            {
                ans++;
                cur=max;
            }
        }
        return ans;
    }
}
