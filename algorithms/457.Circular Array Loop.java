class Solution {
    public boolean circularArrayLoop(int[] a) 
    {
        int i,n=a.length;
        for(i=0;i<n;i++)
        if(a[i]==0) continue;
        else
        {
            int j=i,k=next(i,a[i],n);
            while(a[k]*a[i]>0 && a[next(k,a[k],n)]*a[i]>0) 
            {
                if(j==k) 
                {
                    if(j==next(j,a[j],n)) break;
                    return true;
                }
                j=next(j,a[j],n);
                k=next(k,a[k],n);
                k=next(k,a[k],n);
            }
            
            j=i;
            int val=a[i];
            while(a[j]*val>0) 
            {
                int next=next(j,a[j],n);
                a[j]=0;
                j=next;
            }
        }
        return false;
    }
    
    int next(int i,int k,int n)
    {
        i+=k;
        i%=n;
        if(i<0) i=n+i;
        return i;
    }
}
