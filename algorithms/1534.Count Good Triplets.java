class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int x=0,i,j,k,n=arr.length;
        for(i=0;i<n;i++)
        for(j=i+1;j<n;j++)
        for(k=j+1;k<n;k++)
        {
            int d1=Math.abs(arr[i]-arr[j]),d2=Math.abs(arr[j]-arr[k]),d3=Math.abs(arr[k]-arr[i]);
            if(d1<=a && d2<=b && d3<=c) x++;
        }    
        return x;
    }
}
