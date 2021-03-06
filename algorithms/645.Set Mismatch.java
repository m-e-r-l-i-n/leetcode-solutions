class Solution {
    public int[] findErrorNums(int[] a) {
        int i,n=a.length,c[]=new int[n+1],ans[]={-1,-1};
        for(i=0;i<n;i++) 
        c[a[i]]++;
        for(i=1;i<=n;i++)
        if(c[i]==0) ans[1]=i;
        else if(c[i]==2) ans[0]=i;
        return ans;
    }
}
