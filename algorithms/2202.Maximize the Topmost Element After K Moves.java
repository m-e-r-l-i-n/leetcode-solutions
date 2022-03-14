//Tamonash Chakraborty
//O(n)
class Solution {
    public int maximumTop(int[] nums, int k) {
        int ans=-1,i,n=nums.length;
        //for(i=0;i<n/2;i++) nums[i]=nums[i]^nums[n-1-i]^(nums[n-1-i]=nums[i]);
        for(i=0;i<n && k>=0;i++,k--)	//check if we can use this number
        {
            if(k%2==0) ans=Math.max(ans,nums[i]);	//for even, we can always use this
            else if(k>1)	//not possible in 1 move
            {
                if(i>0)	ans=Math.max(ans,nums[i]);
                //pop this->even moves>0 left,->push pop push pop till >2 moves left, push any prev, push this
                if(i<n-1) ans=Math.max(ans,nums[i]);
                //pop this->even moves>0 left ->pop push pop push next element till >2 moves->pop next->push this
            }
        }
        return ans;
    }
}
