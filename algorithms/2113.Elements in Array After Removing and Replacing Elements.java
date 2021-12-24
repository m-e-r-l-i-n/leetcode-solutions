//Tamonash Chakraborty
//O(q), O(1) per query
class Solution {
    public int[] elementInNums(int[] nums, int[][] queries) {
        int n=nums.length,q=queries.length,ans[]=new int[q],i;
        for(i=0;i<q;i++)
        {
            int min=queries[i][0];
            min%=2*n;
            if(min==0) min=2*n;
            if(min>n)   //elements are reappearing
            {
                min-=n;
                if(queries[i][1]<min) ans[i]=nums[queries[i][1]];
                else ans[i]=-1;
            }
            else    //elements are being deleted
            {
                //min elements have been deleted
                if(min+queries[i][1]<n) ans[i]=nums[queries[i][1]+min]; 
                else ans[i]=-1;
            }
        }
        return ans;
    }
}
