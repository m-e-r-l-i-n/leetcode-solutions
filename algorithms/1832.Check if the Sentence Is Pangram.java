class Solution {
    public boolean checkIfPangram(String s) {
        boolean p[]=new boolean[26];
        int i;
        for(i=0;i<s.length();i++) p[s.charAt(i)-'a']=true;
        boolean ans=true;
        for(i=0;i<26;i++) ans&=p[i];
        return ans;
    }
}
