class Solution {
    public boolean areOccurrencesEqual(String s) {
        int c[]=new int[26],i;
        for(i=0;i<s.length();i++) c[s.charAt(i)-'a']++;
        
        boolean ans=true; int cr=-1;
        for(i=0;i<26;i++)
        if(c[i]!=0)
        {
            if(cr==-1) cr=c[i];
            ans&=cr==c[i];
        }
        return ans;
    }
}
