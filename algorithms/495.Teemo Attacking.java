class Solution {
    public int findPoisonedDuration(int[] t, int d) 
    {
        int i,n=t.length,c=0,tot=0;
        for(i=0;i<n;i++)
        if(c<=t[i])
        {
            tot+=d;
            c=t[i]+d;
        }
        else
        {
            tot+=t[i]+d-c;
            c=t[i]+d;
        }
        return tot;
    }
}
