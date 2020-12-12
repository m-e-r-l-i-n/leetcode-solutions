class Solution {
    public int removeDuplicates(int[] a) 
    {
        int n=a.length;
        if(n==0) return 0;
        int s=0,i,c=a[0],l=1;
        for(i=1;i<n;i++)
        if(a[i]==c) l++;
        else
        {
            a[s++]=c;
            if(l>1) a[s++]=c;
            c=a[i];
            l=1;
        }
        a[s++]=c;
        if(l>1) a[s++]=c;
        return s;
    }
}
