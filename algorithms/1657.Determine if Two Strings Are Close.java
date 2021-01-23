class Solution {
    public boolean closeStrings(String w1, String w2) {
        if(w1.length()!=w2.length()) return false;
        int c1[]=new int[26],c2[]=new int[26],i,n=w1.length();
        for(i=0;i<n;i++)
        c1[w1.charAt(i)-'a']++;
        for(i=0;i<n;i++)
        c2[w2.charAt(i)-'a']++;
        
        for(i=0;i<26;i++)
        if(c1[i]!=c2[i] && !exists(c1,c2,i)) return false;
        return true;
    }
    
    boolean exists(int a[],int b[],int c)
    {
        if(a[c]==0 || b[c]==0) return false;
        int i,p=-1;
        for(i=0;i<26;i++)
        if(a[i]==b[i]) continue;
        else if(b[c]==a[i]) {p=i; break;}
        if(p==-1) return false;
        a[c]=a[c]^a[p]^(a[p]=a[c]);
        return true;
    }
}
