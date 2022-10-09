class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int N=50000;
        bit=new int[N*2+1];
        long ans=0;
        for(int i=0;i<nums1.length;i++)
        {
            int here=nums1[i]-nums2[i];
            here+=diff;
            here+=N;
            ans+=query(here);
            update(here-diff,2*N);
        }
        return ans;
    }
    
    int bit[];
    void update(int i,int N)
    {
        i++;
        while(i<=N)
        {
            bit[i]++;
            i+=i&-i;
        }
    }
    
    int query(int i)
    {
        i++;
        int s=0;
        while(i>0)
        {
            s+=bit[i];
            i-=i&-i;
        }
        return s;
    }
}
