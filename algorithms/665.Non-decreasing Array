class Solution {
    public boolean checkPossibility(int[] nums) {
        int i,c=0;
        for(i=1;i<nums.length;i++)
            if(nums[i]<nums[i-1]) 
            {
                if(c==1) return false;
                else
                {
                    if(i-2>=0 && nums[i-2]>nums[i]) nums[i]=nums[i-1];
                    else nums[i-1]=nums[i];
                    c=1;
                }
            }
        return true;        
    }
}
