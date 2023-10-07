class Solution {
    public int minOperations(int[] nums) {
        int n=Math.max(nums.length,5),dp[]=new int[n+1],i;
        dp[2]=dp[3]=1;
        dp[4]=dp[5]=2;
        for(i=6;i<=n;i++)
        dp[i]=Math.min(dp[i-2],dp[i-3])+1;
        
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int x:nums)
        hm.put(x,hm.getOrDefault(x,0)+1);
        
        int ans=0;
        for(int x:hm.keySet())
        if(hm.get(x)<=1) return -1;
        else ans+=dp[hm.get(x)];
        return ans;
    }
}
