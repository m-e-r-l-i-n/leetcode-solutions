class Solution {
    public int[] constructArray(int n, int k) {
        int i,l=1,r=n,a[]=new int[n];
        for(i=0;i<n;i++)
        {
            if(k%2==0) a[i]=l++;
            else a[i]=r--;
            if(k>1) k--;
        }
        return a;
    }
}
