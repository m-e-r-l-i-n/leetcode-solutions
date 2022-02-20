//Tamonash Chakraborty
//O(n^2)
class Solution {
    public int countPairs(int[] nums, int k) {
        int i,j,n=nums.length,ans=0;
        for(i=0;i<n;i++)    //run a nested loop and check brute force solution
        for(j=i+1;j<n;j++)
        if(nums[i]==nums[j] && i*j%k==0) ans++; 
        return ans;
    }
}
