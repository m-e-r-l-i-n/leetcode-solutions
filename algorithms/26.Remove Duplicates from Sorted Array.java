class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        int i,last=nums[0],l=1,j,fin=nums.length;
        for(i=1;i<fin;i++)
            if(nums[i]==last)
            {
                for(j=i;j<fin-1;j++)
                    nums[j]=nums[j+1];
                i--; fin--;
            }
            else {last=nums[i];l++;}
        return l;
    }
}
