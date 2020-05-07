class Solution {
    public int maxProfit(int[] prices) 
    {
        int i,pr=0,l=0;
        for(i=1;i<prices.length;i++)
            if(prices[i]>prices[i-1]) l++;
            else
            {
                pr+=prices[i-1]-prices[i-l-1];
                l=0;
            }
        if(l!=0)
            pr+=prices[i-1]-prices[i-l-1];
        return pr;
    }
}
