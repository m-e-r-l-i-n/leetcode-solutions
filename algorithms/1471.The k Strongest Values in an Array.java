class Solution {
    public int[] getStrongest(int[] arr, int k) {
        int ans[]=new int[k],i,n=arr.length;
        Arrays.sort(arr);
        int m=arr[(n-1)/2],a[][]=new int[n][2];
        for(i=0;i<n;i++)
        {
            a[i][0]=Math.abs(arr[i]-m);
            a[i][1]=arr[i];
        }
        Arrays.sort(a,new Comparator<int[]>(){
            public int compare(int o1[],int o2[])
            {
                if(o1[0]<o2[0]) return 1;
                else if(o1[0]==o2[0])
                {
                    if(o1[1]<o2[1]) return 1;
                    else return -1;
                }
                else return -1;                
            }});
        for(i=0;i<k;i++)
        ans[i]=a[i][1];
        return ans;
    }
}
