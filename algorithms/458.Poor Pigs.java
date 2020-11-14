class Solution {
    public int poorPigs(int buckets, int die, int test) {
        if (buckets--==1) return 0;
        int base=test/die+1;
        int ans=0;
        while(buckets>0)
        {
            buckets/=base;
            ans++;
        }
        return ans;
    }
}
