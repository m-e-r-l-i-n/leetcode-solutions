class Solution {
    public int[] finalPrices(int[] prices) {
        int n=prices.length,ans[]=new int[n],i,j;
        for(i=0;i<n;i++)
        {
            int min=prices[i];
            for(j=i+1;j<n;j++)
            if(prices[j]<=min) {min-=prices[j]; break;}
            ans[i]=min;
        }    
        return ans;
    }
}
