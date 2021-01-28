class Solution {
    public int concatenatedBinary(int n) {
        int i,l=0;
        long ans=0,M=1000000007;
        for(i=1;i<=n;i++)
        {
            l+=(i&(i-1))==0?1:0;
            ans<<=l;
            ans|=i;
            ans%=M;
        }
        return (int)ans;
    }
}
