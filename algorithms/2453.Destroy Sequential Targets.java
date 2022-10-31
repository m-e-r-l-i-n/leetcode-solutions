class Solution {
    public int destroyTargets(int[] nums, int space) {
        HashMap<Integer,Integer> c=new HashMap<>(),m=new HashMap<>();
        for(int x:nums)
        {
            int y=x%space;
            c.put(y,c.getOrDefault(y,0)+1);
            m.put(y,Math.min(m.getOrDefault(y,Integer.MAX_VALUE),x));
        }    
        
        int max=0,ans=Integer.MAX_VALUE;
        for(int x:c.keySet())
        if(c.get(x)>max)
        {
            max=c.get(x);
            ans=m.get(x);
        }
        else if(c.get(x)==max) ans=Math.min(ans,m.get(x));
        return ans;
    }
}
