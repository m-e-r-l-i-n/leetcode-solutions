class Solution {
    public int threeSumClosest(int[] a, int t) {
        int i,n=a.length,ans=a[0]+a[1]+a[2];
        Arrays.sort(a);
        for(i=0;i+2<n;i++)
        {
            int m=i+1,e=n-1;
            while(m<e) 
            {
                int sum=a[i]+a[m]+a[e];
                if(sum>t) e--;
                else m++;
                if(Math.abs(t-sum)<Math.abs(t-ans)) ans=sum;
            }
        }
        return ans;
    }
}
