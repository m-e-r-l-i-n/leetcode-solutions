class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k<1 || t<0) return false;
        TreeSet<Long> ts=new TreeSet<>();
        for(int i=0;i<nums.length;i++)
        {
            long ch=nums[i];
            ch+=t;
            Long floor=ts.floor(ch);
            ch-=2l*t;
            Long ceil=ts.ceiling(ch);
            if((floor!=null && floor>=nums[i]) || (ceil!=null && ceil<=nums[i])) return true;
            
            ts.add(1l*nums[i]);
            if(i>=k) ts.remove(1l*nums[i-k]);
        }
        return false;
    }
}
