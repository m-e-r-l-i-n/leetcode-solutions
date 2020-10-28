class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans=new ArrayList<>();
        int n=nums.length,i;
        if(n==0) return ans;
        int s=nums[0],e=s;
        for(i=1;i<n;i++)
        if(nums[i]==e+1) e++;
        else
        {
            String v="";
            if(s==e) v=""+s;
            else v=""+s+"->"+e;
            ans.add(v);
            s=e=nums[i];
        }
        String v="";
        if(s==e) v=""+s;
        else v=""+s+"->"+e;
        ans.add(v);
        return ans;
    }
}
