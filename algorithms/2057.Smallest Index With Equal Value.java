//Tamonash Chakraborty
//O(n)
class Solution {
    public int smallestEqual(int[] nums) {
        int i=0,n=nums.length;
        for(i=0;i<n;i++)
        if(i%10==nums[i]) return i;
        return -1;
    }
}
