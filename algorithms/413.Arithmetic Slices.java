class Solution {
    public int numberOfArithmeticSlices(int[] a) 
    {
        int n=a.length,ans=0,i;
        for(i=0;i<n-1;i++)
        {
            int j=i+2,c=0,d=a[i+1]-a[i];
            while(j<n && a[j]-a[j-1]==d) {j++; c++;}
            i=j-2;
            ans+=c*(c+1)/2;
        }    
        return ans;
    }
}
