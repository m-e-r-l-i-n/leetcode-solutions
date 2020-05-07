class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length,min[]=new int[n],max=0,d=0,i,m=10000000;
        for(i=0;i<n;i++)
        {
            if(prices[i]<m) m=prices[i];
            min[i]=m;
        }
        for(i=n-1;i>=0;i--)
        {
            if(prices[i]>max) max=prices[i];
            if(max-min[i]>d) d=max-min[i];
        }
        return d;
    }
}
