class Solution {
    public String minWindow(String s, String t) {
        int ca[]=new int[60],cb[]=new int[60],i;
        for(i=0;i<t.length();i++) cb[t.charAt(i)-'A']++;
        
        int n=s.length(),al=-1,ar=n,l=0;
        for(i=0;i<n;i++)
        {
            ca[s.charAt(i)-'A']++;
            while(l<=i && possible(ca,cb)) 
            {
                if(i-l<=ar-al)
                {
                    ar=i;
                    al=l;
                }
                ca[s.charAt(l++)-'A']--;
            }
        }
        String ans="";
        if(al!=-1) ans=s.substring(al,ar+1);
        return ans;
    }
    
    boolean possible(int a[],int b[])
    {
        int i,n=60;
        for(i=0;i<n;i++)
        if(a[i]<b[i]) return false;
        return true;
    }
}
