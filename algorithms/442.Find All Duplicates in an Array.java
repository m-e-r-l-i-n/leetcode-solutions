class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            int in=Math.abs(nums[i])-1;
            if(nums[in]<0) res.add(in+1);
            nums[in]=-nums[in];
        }
        return res;
    }
}
