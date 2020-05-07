class Solution {
    public int numJewelsInStones(String j, String s) {
        int c[]=new int[52],i,a=0;
        for(i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch>='A' && ch<='Z') c[ch-'A']++;
            else c[26+ch-'a']++;
        }
        
        for(i=0;i<j.length();i++)
        {
            char ch=j.charAt(i);
            if(ch>='A' && ch<='Z') a+=c[ch-'A'];
            else a+=c[26+ch-'a'];
        }
        return a;
    }
}
