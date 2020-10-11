class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        if(palindrome(a) || palindrome(b)) return true;
        if(check(a,b)) return true;
        if(check(b,a)) return true;
        return false;
    }
    
    boolean check(String a,String b)
    {
        int i,j,n=a.length();
        for(i=0;i<n/2;i++)
        if(a.charAt(i)!=b.charAt(n-i-1)) break;
        if(i==0) return false;
        
        String s=a.substring(0,i)+b.substring(i);
        if(palindrome(s)) return true;
        s=a.substring(0,n-i)+b.substring(n-i);
        if(palindrome(s)) return true;
        return false;
    }
    
    boolean palindrome(String s)
    {
        int i,n=s.length();
        for(i=0;i<n/2;i++)
        if(s.charAt(i)!=s.charAt(n-i-1)) return false;
        return true;
    }
}
