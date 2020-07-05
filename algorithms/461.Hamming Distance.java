class Solution {
    public int hammingDistance(int x, int y) {
        int a=x^y,c=0;
        while(a!=0)
        {
            if((a&1)==1) c++;
            a>>=1;
        }
        return c;
    }
}
