class Solution {
    public void sortColors(int[] nums) {
        int i,c[]=new int[3],j,t=0;
        for(i=0;i<nums.length;i++)
            c[nums[i]]++;
        for(i=0;i<3;i++)
        for(j=0;j<c[i];j++)
            nums[t++]=i;
    }
}
