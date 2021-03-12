class Solution {
    public int removePalindromeSub(String s) {
        if(s.length()==0) return 0;
        int i,n=s.length();
        boolean p=true;
        for(i=0;i<n/2;i++)
        if(s.charAt(i)!=s.charAt(n-i-1)) {p=false; break;}
        if(p) return 1;
        return 2;
    }
}
