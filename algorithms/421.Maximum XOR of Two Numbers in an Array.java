class Solution {
    public int findMaximumXOR(int[] nums) {
        int i,j,mask=0,max=0;
        for(i=30;i>=0;i--)
        {
            mask|=1<<i;
            Set<Integer> s=new HashSet<>();
            for(j=0;j<nums.length;j++)
            s.add(nums[j]&mask);
            int nm=max|(1<<i);
            for(int x:s)
            if(s.contains(nm^x)) 
            {max=nm; break;}    
        }
        return max;
    }
}
