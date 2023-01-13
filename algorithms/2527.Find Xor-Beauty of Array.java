class Solution {
    public int xorBeauty(int[] nums) {
        //nums[i] will be AND with nums[i] (and possibly other values)
        //this means nums[i] will exist in answer
        //all values need to be XORed, so ans is XOR of array
        int ans=0;
        for(int x:nums) ans^=x;
        return ans;
    }
}
