class Solution {
    public boolean halvesAreAlike(String s) {
        int n=s.length(),i,v=0;
        for(i=0;i<n/2;i++)
        if(vowel(s.charAt(i))) v++;
        for(i=n/2;i<n;i++)
        if(vowel(s.charAt(i))) v--;
        return v==0;
    }
    
    static boolean vowel(char c)
    {
        if(c>='A' && c<='Z') c=(char)(c+32);
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') return true;
        return false;
    }
}
