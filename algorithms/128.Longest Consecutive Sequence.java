class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s=new HashSet<>();
        for(int x:nums) s.add(x);
        int ans=0;
        for(int x:s)
        {
            if(s.contains(x-1)) continue;
            int cur=0,i=x;
            while(s.contains(i))
            {
                cur++;
                i++;
            }
            ans=Math.max(ans,cur);
        }
        return ans;
    }
}
