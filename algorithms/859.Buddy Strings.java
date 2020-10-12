class Solution {
    public boolean buddyStrings(String a, String b) {
        int n=a.length(),m=b.length();
        if(n!=m) return false;
        int i,c[]=new int[2],j=0,ca[]=new int[26];
        for(i=0;i<n;i++)
        {
            if(a.charAt(i)!=b.charAt(i))
            {
                if(j==2) return false;
                c[j++]=i;
            }
            ca[a.charAt(i)-'a']++;
        }
        if(j==0) 
        {
            for(i=0;i<26;i++)
            if(ca[i]>1) return true;
            return false;
        }   
        if(j==2) return a.charAt(c[1])==b.charAt(c[0]) && a.charAt(c[0])==b.charAt(c[1]);
        
        for(i=0;i<n;i++)
        if(a.charAt(i)==b.charAt(c[0]) && b.charAt(i)==a.charAt(c[0])) return true;
        return false;        
    }
}
