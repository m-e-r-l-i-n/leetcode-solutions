//Tamonash Chakraborty
//O(nlogn)
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);  //sort nums
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        if(nums[i]==target) ans.add(i); //find the required indices
        return ans; //return it
    }
}
