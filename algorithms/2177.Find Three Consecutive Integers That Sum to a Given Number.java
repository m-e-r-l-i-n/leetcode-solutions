class Solution {
    public long[] sumOfThree(long num) {
        //n-1,n,n+1 be the 3 numbers. So n-1+n+n+1=3n is sum
        long[] ret = new long[0];
        if (num%3 != 0)
            return ret;
        ret = new long[3];
        ret[0] = num/3-1;
        ret[1] = num/3;
        ret[2] = num/3+1;
        return ret;
    }
}
