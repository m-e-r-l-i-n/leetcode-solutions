class Solution {
    public int sumOfUnique(int[] a) {
        int c[]=new int[101],i,n=a.length;
        for(i=0;i<n;i++) c[a[i]]++;
        int ans=0;
        for(i=0;i<=100;i++)
        if(c[i]==1) ans+=i;
        return ans;
    }
}
