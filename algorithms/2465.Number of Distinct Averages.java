class Solution {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set=new HashSet<>();
        int l=0,r=nums.length-1;
        while(l<r) set.add(nums[l++]+nums[r--]);
        return set.size();
    }
}
