class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        long add=0,sub=0;
        for(int i=0;i<nums1.length;i++)
        if(nums1[i]>nums2[i]) 
        {
            int d=nums1[i]-nums2[i];
            if(k==0 || d%k!=0) return -1;
            sub+=d/k;
        }
        else if(nums1[i]<nums2[i])
        {
            int d=nums2[i]-nums1[i];
            if(k==0 || d%k!=0) return -1;
            add+=d/k;
        }
        return add==sub?add:-1;
    }
}
