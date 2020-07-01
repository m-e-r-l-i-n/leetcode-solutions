class Solution {
    public int arrangeCoins(int sum) {
        double n=8.0*sum,x=(Math.sqrt(1.0+n)-1)/2;
        return (int)Math.floor(x);
    }
}
