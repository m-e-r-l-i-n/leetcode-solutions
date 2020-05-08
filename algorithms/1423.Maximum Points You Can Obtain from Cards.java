class Solution {
    public int maxScore(int[] c, int k) {
        int i,n=c.length,suml[]=new int[k+1],sumr[]=new int[k+1],sum1=0,sum2=0;
        for(i=0;i<k;i++)
        {
            sum1+=c[i];
            sum2+=c[n-i-1];
            suml[i+1]=sum1;
            sumr[k-(i+1)]=sum2;
        }
        int max=0;
        for(i=0;i<=k;i++)
            if(suml[i]+sumr[i]>max) max=suml[i]+sumr[i];
        return max;
    }
}
