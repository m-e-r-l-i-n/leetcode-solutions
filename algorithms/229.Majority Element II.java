class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        if(nums.length==0) return ans;
        int c1=0,c2=0,can1=0,can2=1;
        for(int n:nums)
        {
            if(n==can1) c1++;
            else if(n==can2) c2++;
            else if(c1==0)
            {can1=n; c1=1;}
            else if(c2==0)
            {can2=n; c2=1;}
            else
            {c1--; c2--;}
        }
        c1=0; c2=0;
        for(int n:nums)
        {
            if(n==can1) c1++;
            else if(n==can2) c2++;
        }
        if(c1>nums.length/3) ans.add(can1);
        if(c2>nums.length/3) ans.add(can2);
        return ans;
    }
}
