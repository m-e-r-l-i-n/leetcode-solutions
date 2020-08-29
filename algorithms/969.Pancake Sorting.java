class Solution {
    public List<Integer> pancakeSort(int[] a) {
        List<Integer> ans=new ArrayList<>();
        int i,n=a.length,j,k,in[]=new int[n+1];
        for(i=0;i<n;i++)
            in[a[i]]=i;
        
        for(i=n-1;i>=0;i--)
        if(a[i]==i+1) continue;
        else
        {
            ans.add(in[i+1]+1);
            reverse(in[i+1],a,in);
            ans.add(i+1);
            reverse(i,a,in);
        }
        return ans;
    }
    
    void reverse(int e,int a[],int in[])
    {
        int i;
        for(i=0;i<(e+1)/2;i++)
        {
            a[i]=a[i]^a[e-i]^(a[e-i]=a[i]);
            in[a[i]]=i;
            in[a[e-i]]=e-i;
        }
    }
}
