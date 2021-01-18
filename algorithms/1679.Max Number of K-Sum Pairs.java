class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int ans=0;
        for(int x:nums)
        hm.put(x,hm.getOrDefault(x,0)+1);
        for(int x:hm.keySet())
        {
            int y=k-x;
            if(y==x) ans+=hm.get(x)-(hm.get(x)%2);
            else if(hm.get(y)!=null) ans+=Math.min(hm.get(y),hm.get(x));
        }
        return ans/2;
    }
}
