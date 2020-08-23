class Solution {
    public int findLatestStep(int[] arr, int m) {
        int i,n=arr.length,l[]=new int[n+2],c[]=new int[n+1],ans=-1;
        if(m==n) return n;
        for(i=0;i<n;i++)
        {
            int a=arr[i],le=l[a-1],ri=l[a+1];
            l[a]=l[a-le]=l[a+ri]=le+ri+1;
            c[le]--;
            c[ri]--;
            c[l[a]]++;
            if(c[m]>0) ans=i+1;
        }
        return ans;
    }
}
