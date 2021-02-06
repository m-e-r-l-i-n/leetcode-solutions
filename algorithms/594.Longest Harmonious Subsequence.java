class Solution {
    public int findLHS(int[] nums) {
        TreeMap<Integer,Integer> tm=new TreeMap<>();
        for(int x:nums)
        tm.put(x,tm.getOrDefault(x,0)+1);
        int ans=0;
        for(int x:tm.keySet())
        if(tm.get(x+1)!=null) ans=Math.max(ans,tm.get(x)+tm.get(x+1));
        return ans;
    }
}
