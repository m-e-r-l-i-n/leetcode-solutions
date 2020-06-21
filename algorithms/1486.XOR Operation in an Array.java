class Solution {
    public int xorOperation(int n, int start) {
        int ans=start,i,k;
        for(i=1;i<n;i++)
        {
            k=start+2*i;
            ans^=k;
        }
        return ans;
    }
}
