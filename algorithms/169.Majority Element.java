class Solution {
    public int majorityElement(int[] nums) {
        int i,n=nums.length,maj=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(i=0;i<n;i++)
        {
            if(hm.get(nums[i])==null) hm.put(nums[i],1);
            else hm.put(nums[i],hm.get(nums[i])+1);
            if(hm.get(nums[i])>n/2) {maj=nums[i]; break;}
        }    
        return maj;
    }
}
