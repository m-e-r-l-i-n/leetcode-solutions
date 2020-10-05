class Solution {
    public int bitwiseComplement(int N) {
        if(n==0) return 1;
        int ans=0,p2=1;
        while(n!=0)
        {
            if(n%2==0) ans+=p2;
            p2*=2;
            n/=2;
        }
        return ans;
    }
}
