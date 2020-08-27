class Solution {
    public int[] findRightInterval(int[][] in) {
        int n=in.length,i,ans[]=new int[n],a[][]=new int[n][2];
        for(i=0;i<n;i++)
        {
            a[i][0]=in[i][0];
            a[i][1]=i;
        }
        Arrays.sort(a, new Comparator<int[]>(){
            public int compare(int o1[],int o2[])
            {
                if(o1[0]>o2[0]) return 1;
                else return -1;
            }
        });
        
        for(i=0;i<n;i++)
        {
            int p=bsearch(a,in[i][1]);
            ans[i]=p;
        }
        return ans;
    }
    
    int bsearch(int a[][],int key)
    {
        int l=0,r=a.length-1,mid,ans=-1;
        while(l<=r)
        {
            mid=(l+r)/2;
            if(a[mid][0]>=key)
            {
                ans=a[mid][1];
                r=mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }
}
