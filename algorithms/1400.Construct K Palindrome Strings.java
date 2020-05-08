class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length()<k) return false;
        else if(s.length()==k) return true;
        
        int c[]=new int[26],i;
        for(i=0;i<s.length();i++)
            c[s.charAt(i)-97]++;
        int e=0,o=0;
        for(i=0;i<26;i++)
        {e+=c[i]/2;
         o+=c[i]%2;}
        if(o>k) return false;
        else return true;    
    }
}
