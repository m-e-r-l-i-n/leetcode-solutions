class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int ans=0,i,n=arr.length;
        for(i=0;i<n;i++)
        {
            int left=i+1,right=n-i;
            int lo=(left+1)/2,le=left-lo,ro=(right+1)/2,re=right-ro;
            ans+=(lo*ro+le*re)*arr[i];
        }
        return ans;
    }
}
