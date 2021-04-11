class Solution {
    public int arraySign(int[] nums) {
        int ne=0,ze=0;
        for(int x:nums)
        if(x<0) ne++;
        else if(x==0) ze++;
        if(ze>0) return 0;
        if(ne%2==1) return -1;
        return 1;
    }
}
