class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb=new StringBuilder();
        int i;
        for(i=0;i<s.length();i++)
        if(valid(s.charAt(i))) sb.append(value(s.charAt(i)));
        
        if(sb.length()<2) return true;
        
        s=sb.toString(); int n=s.length();
        for(i=0;i<n/2;i++)
        if(s.charAt(i)!=s.charAt(n-i-1)) return false;
        return true;
    }
    
    boolean valid(char c)
    {
        if((c>='A' && c<='Z') || (c>='a' && c<='z') || (c>='0' && c<='9')) return true;
        return false;
    }
    
    char value(char c)
    {
        if(c>='A' && c<='Z') c=(char)(c+32);
        return c;
    }
}
