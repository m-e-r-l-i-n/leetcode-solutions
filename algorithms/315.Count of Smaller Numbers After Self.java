class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int i,n=nums.length;
        Integer ans[]=new Integer[n];
        for(i=n-1;i>=0;i--)
        {
            update(nums[i]+10000);
            ans[i]=query(nums[i]+10000);
        }
        return Arrays.asList(ans);
    }
    
    int N=20001,bit[]=new int[N+1];
    void update(int i)
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
        int s=0;
        while(i>0)
        {
            s+=bit[i];
            i-=i&-i;
        }
        return s;
    }
}
