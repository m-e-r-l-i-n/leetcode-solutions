class Solution {
    public int alternatingSubarray(int[] a) {
        int i=0,n=a.length,max=-1;
        while(i+1<n)
        {
            if(a[i+1]-a[i]!=1) {i++; continue;} //cannot be an alternating subarray start
            int j=i+2; boolean neg=true;
            while(j<n)
            {
                if(neg && a[j]-a[j-1]==-1 || (!neg && a[j]-a[j-1]==1))
                {
                    neg=!neg;
                    j++;
                }
                else break;
            }
            max=Math.max(max,j-i);
            i=j-1;
        }
        return max;
    }
}
