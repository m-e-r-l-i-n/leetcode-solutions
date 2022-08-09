class Solution {
    public long countBadPairs(int[] nums) {
        long good=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        int i,n=nums.length;
        for(i=0;i<n;i++)
        {
            int v=hm.getOrDefault(nums[i]-i,0);
            good+=v;
            hm.put(nums[i]-i,v+1);
        }
        return 1l*n*(n-1)/2-good;
    }
}
