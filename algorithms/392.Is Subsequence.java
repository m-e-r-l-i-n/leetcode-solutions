class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0) return true;
        if(t.length()<s.length()) return false;
        int i,cur=0;
        for(i=0;i<t.length();i++)
        {
            if(s.charAt(cur)==t.charAt(i)) cur++;
            if(cur==s.length()) break;
        }
        return cur==s.length();
    }
}
