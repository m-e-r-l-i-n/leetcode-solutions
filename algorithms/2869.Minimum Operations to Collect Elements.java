class Solution {
    public int minOperations(List<Integer> nums, int k) {
        long key=(1l<<(k+1))-1,cur=1;
        int ans=0,i,n=nums.size();
        for(i=n-1;i>=0;i--)
        {
            int x=nums.get(i);
            ans++;
            if(x<=k) cur|=1l<<x;
            if(cur==key) break;
        }
        return ans;
    }
}
