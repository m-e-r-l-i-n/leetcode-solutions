//Tamonash Chakraborty
//O(n)
class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int n=nums.length,one=0,i;
        for(i=0;i<n;i++) one+=nums[i];  //number of ones
        
        List<Integer> ans=new ArrayList<>();
        int max=0,prez=0,preo=0;  //zeros and ones <i respectively
        for(i=0;i<n;i++)
        {
            int cur=prez+(one-preo);
            if(cur==max) ans.add(i);
            else if(cur>max)
            {
                ans=new ArrayList<>();
                ans.add(i);
                max=cur;
            }
            if(nums[i]==0) prez++;
            else preo++;
        }
        if(prez==max) ans.add(i);   //for i==n
        else if(prez>max)
        {
            ans=new ArrayList<>();
            ans.add(i);
        }
        return ans;
    }
}
