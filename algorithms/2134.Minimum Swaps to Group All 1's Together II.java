//Tamonash Chakraborty
//O(n)
class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length,a[]=new int[n*2],i,one=0;
        for(i=0;i<n;i++)
        {
            a[i]=a[n+i]=nums[i];
            if(a[i]==1) one++;
        }
        
        int here=0,ans;
        for(i=0;i<one;i++)
        here+=a[i];
        ans=one-here;   //first group of 'one' 1s
        
        for(i=one;i<2*n;i++)
        {
            here-=a[i-one]; //number of ones in the range
            here+=a[i];
            ans=Math.min(ans,one-here); //we need to add the remaining 1s by swapping
        }
        return ans;
    }
}
