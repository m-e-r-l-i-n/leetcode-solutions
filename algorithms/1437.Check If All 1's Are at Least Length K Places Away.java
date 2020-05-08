class Solution {
    public boolean kLengthApart(int[] nums, int k) 
    {
        ArrayList<Integer> p=new ArrayList<>();
        int i;
        for(i=0;i<nums.length;i++)
            if(nums[i]==1) p.add(i);
        if(p.size()<2) return true;
        for(i=1;i<p.size();i++)
            if((p.get(i)-p.get(i-1)-1)<k) return false;
        return true;
    }
}
