class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int n=s.length(),l=1,r=n/k,mid;
        String ans="";
        str=new char[n];
        while(l<=r)
        {
            mid=(l+r)>>1;
            if(possible(s,mid,k))
            {
                ans="";
                for(int i=0;i<mid;i++) ans+=str[i];
                l=mid+1;
            }    
            else r=mid-1;
        }
        return ans;
    }
    
    boolean subsequence(String a,char[] b,int m,int k)
    {
        int i,n=a.length(),j=0,t=0;
        for(i=0;i<n;i++)
        {
            if(a.charAt(i)==b[j]) j++;
            if(j==m) {t++; j=0;}
            if(t==k) return true;
        }
        return false;
    }
    
    int c[][],next[][],used[];
    boolean possible(String s,int m,int k)
    {
        int i,j,n=s.length();
        c=new int[n+1][26];
        next=new int[n+1][26];
        used=new int[26];
        for(i=0;i<26;i++) next[n][i]=-1;
        for(i=n-1;i>=0;i--) 
        {
            for(j=0;j<26;j++)
            {
                next[i][j]=next[i+1][j];
                c[i][j]=c[i+1][j];
            }
            c[i][s.charAt(i)-'a']++;
            next[i][s.charAt(i)-'a']=i;
        }
        return recur(s,0,0,m,k); 
    }
    
    char str[];
    boolean recur(String s,int i,int x,int n,int k)
    {
        int u,v,l=s.length();
        if(x==n) return subsequence(s,str,n,k);
        if(i>=l) return false;
        for(u=25;u>=0;u--)
        if(c[i][u]>=(used[u]+1)*k-used[u])
        {
            used[u]++;
            str[x]=s.charAt(next[i][u]);
            if(recur(s,next[i][u]+1,x+1,n,k)) return true;
            used[u]--;
        }
        return false;
    }
}
