class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        int i=0,j=0,m=nums1.length,n=nums2.length; long sum1=0,sum2=0,res=0,M=1000000007;
        while(i<m && j<n)
        {
            if(nums1[i]<nums2[j]) sum1+=nums1[i++];
            else if(nums1[i]>nums2[j]) sum2+=nums2[j++];
            else
            {
                res+=Math.max(sum1,sum2);
                sum1=0; sum2=0;
                while(i<m && j<n && nums1[i]==nums2[j]) 
                {
                    res+=nums1[i++];
                    j++;
                }
            }
        }
        
        while(i<m) sum1+=nums1[i++];
        while(j<n) sum2+=nums2[j++];
        res+=Math.max(sum1,sum2);
        return (int)(res%M);
    }
}
