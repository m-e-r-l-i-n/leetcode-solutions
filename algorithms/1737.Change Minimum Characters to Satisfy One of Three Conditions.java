class Solution {
    public int minCharacters(String a, String b) {
        int ca[]=new int[26],cb[]=new int[26],i,n=a.length(),m=b.length();
        for(i=0;i<n;i++) 
        ca[a.charAt(i)-'a']++;
        for(i=0;i<m;i++)
        cb[b.charAt(i)-'a']++;
        
        int ans=0,mx=0;
        for(i=0;i<26;i++)
        {
            mx=Math.max(mx,ca[i]);
            ans=Math.max(ans,cb[i]);
        }
        ans=m-ans+n-mx;
        ans=Math.min(ans,minima(ca,cb,n));
        ans=Math.min(ans,minima(cb,ca,m));
        return ans;
    }
    
    int minima(int a[],int b[],int n)
    {
        int ans=Integer.MAX_VALUE,i,sa=0,sb=0;
        for(i=0;i<26;i++)
        {
            if(i>0) ans=Math.min(ans,n-sa+sb);
            sa+=a[i];
            sb+=b[i];
            
        }
        return ans;
    }
}
