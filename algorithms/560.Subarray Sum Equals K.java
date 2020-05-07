class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int i,c=0,n=nums.length,sum=0;
        for(i=0;i<n;i++)
        {
            sum+=nums[i];
            if(sum==k) c++;
            if(hm.containsKey(sum-k)) c+=hm.get(sum-k);
            if(hm.get(sum)==null) hm.put(sum,1);
            else hm.put(sum,hm.get(sum)+1);
        }
        return c;
    }
}
