class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n=piles.length,i=n-2,b=0,sum=0;
        while(b<i)
        {
            sum+=piles[i];
            i-=2;
            b++;
        }
        return sum;
    }
}
