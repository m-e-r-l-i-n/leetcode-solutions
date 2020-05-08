class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int i,n=nums.length,sum[]=new int[n+1],s=0;
        for(i=0;i<n;i++)
        {s+=nums[i]; sum[i+1]=s;}
        ArrayList<Integer> al=new ArrayList<>();
        int news=0;
        for(i=n-1;i>=0;i--)
        {
            news+=nums[i];
            al.add(nums[i]);
            if(news>sum[i]) break;
        }
        return al;
    }
}
