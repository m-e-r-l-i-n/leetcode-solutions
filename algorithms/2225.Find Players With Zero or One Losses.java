class Solution {
    public List<List<Integer>> findWinners(int[][] edges) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int x[]:edges)
        {
            hm.put(x[0],hm.getOrDefault(x[0],0));
            hm.put(x[1],hm.getOrDefault(x[1],0)+1);
        }
        
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<2;i++)
        ans.add(new ArrayList<>());
        for(int x:hm.keySet())
        if(hm.get(x)<2) ans.get(hm.get(x)).add(x);
        
        for(int i=0;i<2;i++) Collections.sort(ans.get(i));
        return ans;
    }
}
