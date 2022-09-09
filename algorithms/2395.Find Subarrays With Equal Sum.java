class Solution {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i+1<nums.length;i++)
        {
            int cur=nums[i]+nums[i+1];
            if(set.contains(cur)) return true;
            set.add(cur);
        }
        return false;
    }
}
