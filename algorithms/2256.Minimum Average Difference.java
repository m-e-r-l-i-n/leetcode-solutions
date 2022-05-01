//Tamonash Chakraborty
//O(n)
class Solution {
    public int minimumAverageDifference(int[] nums) {
        long sum=0;
        for(int x:nums) sum+=x; //calculate sum
        
        int i,n=nums.length;
        long pre=0,suf,ans=Long.MAX_VALUE; //prefix sum,suffix sum,ans
        int ind=-1;
        for(i=0;i<n;i++)
        {
            pre+=nums[i];
            suf=sum-pre;
            long diff=0;
            if(i!=n-1) diff=suf/(n-1-i);
            diff-=pre/(i+1);    //calcuate the diff between the 2 averages
            
            diff=Math.abs(diff);
            if(diff<ans)
            {
                ans=diff;
                ind=i;
            }
        }
        return ind;
    }
}
