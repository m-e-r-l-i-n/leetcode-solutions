class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> ans=new ArrayList<>();
        int i,j,n=nums.length,x=0,m=(int)Math.pow(2,n);
        for(i=0;i<m;i++)
        {
            x=i;j=0; int c[]=new int[32];
            while(x!=0)
            {
                if((x&1)==1) c[j]++;
                j++;
                x>>=1;
            }
            
            List<Integer> t=new ArrayList<>();
            for(j=0;j<n;j++)
            if(c[j]==1) t.add(nums[j]);
            ans.add(t);
        }
        return ans;
    }
}
