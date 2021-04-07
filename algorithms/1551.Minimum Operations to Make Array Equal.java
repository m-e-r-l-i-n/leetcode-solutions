class Solution {
    public int minOperations(int n) {
        int s=sumodd(n),o=n/2;  //count of odd numbers smaller than n
        return o*n-sumodd(o);
    }
    
    int sumodd(int n)   //sum of 1st n odd numbers
    {
        return n*n;
    }
}
