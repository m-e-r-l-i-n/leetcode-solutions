class Solution {
    public int[] threeEqualParts(int[] a) {
        int o=0,i,n=a.length,ans[]={-1,-1};
        for(i=0;i<n;i++) o+=a[i];
        if(o%3!=0) return ans;
        if(o==0)
        {
            ans[0]=0;
            ans[1]=n-1;
            return ans;
        }
        
        o/=3;
        int s0=-1,s1=-1,s2=-1,c1=0,c2=0;
        for(i=0;i<n;i++)
        {
            if(a[i]==1) 
            {
                c1++; c2++;
                if(s0==-1) s0=i;
            }
            if(c1==o+1 && s1==-1) s1=i;
            if(c2==2*o+1 && s2==-1) s2=i;
        }
        
        int bad[]={-1,-1};
        while(s2<n && a[s0]==a[s1] && a[s1]==a[s2])
        {
            s1++; s2++; s0++;
        }
        if(s2!=n) return bad;
        ans[0]=s0-1; ans[1]=s1;
        return ans;
    }
}
