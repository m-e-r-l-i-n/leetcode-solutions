class Solution {
    public int maxSubarraySumCircular(int[] a) {
        int n=a.length,max=a[0],min=a[0],sum=a[0],cmax=a[0],cmin=a[0],i;
        for(i=1;i<n;i++)
        {
            sum+=a[i];
            cmax=Math.max(a[i]+cmax,a[i]);  //using Kadane
            cmin=Math.min(a[i]+cmin,a[i]);
            max=Math.max(max,cmax);
            min=Math.min(min,cmin);
        }    
        if(min==sum) return max;    //in this case sum-min=0 which may not be the sum of any subarray
        else return Math.max(max,sum-min);  //due to circular format
    }
}
