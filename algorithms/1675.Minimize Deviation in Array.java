class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> t=new TreeSet<>();
        for(int x:nums)
        if(x%2==1) t.add(2*x);
        else t.add(x);
        
        int ans=Integer.MAX_VALUE;
        while(t.size()>0 && t.last()%2==0)
        {
            int m=t.last();
            t.remove(m);
            t.add(m/2);            
            ans=Math.min(ans,t.last()-t.first());
        }
        return ans;
    }
}
