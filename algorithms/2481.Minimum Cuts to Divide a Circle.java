class Solution {
    public int numberOfCuts(int n) {
        int ans=n;
        if(n==1) ans=0;
        else if(n%2==0) ans=n/2;
        return ans;
    }
}
