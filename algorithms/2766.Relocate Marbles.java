class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        HashMap<Integer,Integer> pos=new HashMap<>();
        for(int x:nums) pos.put(x,pos.getOrDefault(x,0)+1);
        
        for(int i=0;i<moveFrom.length;i++)
        if(moveFrom[i]!=moveTo[i]) 
        {
            pos.put(moveTo[i],pos.getOrDefault(moveFrom[i],0)+pos.getOrDefault(moveTo[i],0));
            pos.put(moveFrom[i],0);
        }
        
        List<Integer> ans=new ArrayList<>();
        for(int x:pos.keySet())
        {
            int v=pos.get(x);
            if(v>0) ans.add(x);
        }    
        Collections.sort(ans);
        return ans;
    }
}
