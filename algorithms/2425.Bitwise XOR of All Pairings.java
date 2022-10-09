class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int ans=0;
        boolean n=nums1.length%2==1,m=nums2.length%2==1;
        for(int x:nums1)
        if(m) ans^=x;
        for(int x:nums2)
        if(n) ans^=x;
        
        return ans;
    }
}
