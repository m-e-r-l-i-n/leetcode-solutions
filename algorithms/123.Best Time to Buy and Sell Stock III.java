class Solution {
    public int maxProfit(int[] prices) {
        int hold1=Integer.MIN_VALUE,hold2=Integer.MIN_VALUE,rel1=0,rel2=0;
        int i,p;
        //use same logic as best time to buy and sell 1 stock
        for(i=0;i<prices.length;i++)
        {
            p=prices[i];
            rel2=Math.max(rel2,hold2+p);    //selling 2nd stock
            hold2=Math.max(hold2,rel1-p);   //buying 2nd stock
            rel1=Math.max(rel1,hold1+p);    //selling 1st stock
            hold1=Math.max(hold1,-p);       //buying 1st stock
        }
        return rel2;
    }
}
