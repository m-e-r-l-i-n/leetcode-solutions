class Solution {
    public int climbStairs(int n) {
        //use fibonacci formula
        n++;
        double s5=Math.sqrt(5);
        double result=1/s5*(Math.pow((1+s5)/2,n)-Math.pow((1-s5)/2,n));
        return (int)result;
    }
}
