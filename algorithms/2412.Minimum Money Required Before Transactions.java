class Solution {
    public long minimumMoney(int[][] transactions) {
        int maxpos=0,maxneg=0;
        long sum=0;
        for(int x[]:transactions)
        {
            if(x[0]<x[1]) maxpos=Math.max(maxpos,x[0]);
            else
            {
                sum+=x[0]-x[1];
                maxneg=Math.max(maxneg,x[1]);
            }
        }    
        return sum+Math.max(maxpos,maxneg);
    }
}
