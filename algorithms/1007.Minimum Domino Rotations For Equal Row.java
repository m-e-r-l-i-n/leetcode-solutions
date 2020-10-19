class Solution {
    public int minDominoRotations(int[] a, int[] b) {
        int i,ans=Integer.MAX_VALUE;
        for(i=1;i<=6;i++)
        ans=Math.min(ans,rotate(a,b,i));
        if(ans==Integer.MAX_VALUE) ans=-1;
        return ans;
    }
    
    int rotate(int a[],int b[],int v)
    {
        int i,n=a.length,m1=0,m2=0;
        for(i=0;i<n;i++)
        {
            if(a[i]!=v && b[i]==v) 
            {
                if(m1!=-1) m1++;
            }
            else if(a[i]!=v && b[i]!=v) m1=-1;
            
            if(b[i]!=v && a[i]==v)
            {
                if(m2!=-1) m2++;
            }
            else if(b[i]!=v && a[i]!=v) m2=-1;
            
            if(m1==-1 && m2==-1) break;
        }
        if(m1==-1 && m2==-1) return Integer.MAX_VALUE;
        if(m1==-1) return m2;
        if(m2==-1) return m1;
        return Math.min(m1,m2);
    }
}
