class Solution {
    public int minCost(String s, int[] cost) {
        int i,n=s.length(),max=cost[0],sum=0,csum=cost[0],cur=s.charAt(0);
        for(i=1;i<n;i++)
        if(s.charAt(i)==cur)
        {
            max=Math.max(max,cost[i]);
            csum+=cost[i];
        }
        else
        {
            sum+=csum-max;
            csum=max=cost[i];
            cur=s.charAt(i);
        }
        sum+=csum-max;
        return sum;
    }
}
