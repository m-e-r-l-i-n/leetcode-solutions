class Solution {
    public String largestTimeFromDigits(int[] a) {
        int i,j,k,l,m[]={-1,-1,-1,-1};
        for(i=0;i<4;i++)
        for(j=0;j<4;j++)
        if(j==i) continue;
        else 
        for(k=0;k<4;k++)
        if(k==i || k==j) continue;
        else
        for(l=0;l<4;l++)
        if(l==i || l==j || l==k) continue;
        else
        {
            if(valid(a[i],a[j],a[k],a[l]))
            {
                int ar[]={a[i],a[j],a[k],a[l]};
                max(m,ar);
            }
        }
        
        String ans="";
        for(i=0;i<2;i++)
        if(m[i]==-1) return "";
        else ans+=(char)(m[i]+'0');
        ans+=':';
        for(i=2;i<4;i++)
        if(m[i]==-1) return "";
        else ans+=(char)(m[i]+'0');
        return ans;        
    }
    
    boolean valid(int i,int j,int k,int l)
    {
        if(i>2) return false;
        if(i==2 && j>3) return false;
        if(k>5) return false;
        return true;
    }
    
    void max(int a[],int b[])
    {
        boolean f=true;
        for(int i=0;i<4;i++)
        if(b[i]==a[i]) continue;
        else
        {
            if(b[i]>a[i]) f=false;
            break;
        }
        if(!f)
        for(int i=0;i<4;i++)
        a[i]=b[i];    
    }
}
