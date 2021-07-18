class Solution {
    public int canBeTypedWords(String t, String b) {
        String s[]=t.split(" ");
        boolean v[]=new boolean[26];
        int i,j,ans=0;
        for(i=0;i<b.length();i++) v[b.charAt(i)-'a']=true;
        
        for(i=0;i<s.length;i++)
        {
            boolean pos=true;
            for(j=0;j<s[i].length();j++)
            if(v[s[i].charAt(j)-'a']) {pos=false; break;}
            if(pos) ans++;
        }
        return ans;
    }
}
