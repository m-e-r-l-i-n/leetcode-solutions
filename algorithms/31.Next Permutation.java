class Solution {
    public void nextPermutation(int[] a) 
    {
        int n=a.length,i=n-1;
	    while(i>0)
	    if(a[i]>a[i-1]) break;
	    else i--;
	    if(i<=0)
	    {
	        Arrays.sort(a);
	        return;
	    }
	    int p=i-1,p2=i;
	    for(i=p+1;i<n;i++)
	    if(a[i]>a[p])
	    {
	        if(a[i]<a[p2]) p2=i;
	    }
	    a[p]=a[p]^a[p2]^(a[p2]=a[p]);
	    Arrays.sort(a,p+1,n);
    }
}
