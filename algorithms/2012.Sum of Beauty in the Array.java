class Solution {
    public int sumOfBeauties(int[] a) {
        int i,n=a.length,min[]=new int[n];
        min[n-1]=a[n-1];
        for(i=n-2;i>=0;i--) min[i]=Math.min(a[i],min[i+1]);
        
        int ans=0,max=a[0];
        for(i=1;i<n-1;i++)
        {
            if(max<a[i] && a[i]<min[i+1]) ans+=2;
            else if(a[i-1]<a[i] && a[i]<a[i+1]) ans++;
            max=Math.max(max,a[i]);
        }    
        return ans;
    }
}
