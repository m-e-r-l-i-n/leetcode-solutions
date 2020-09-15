class Solution {
    public int lengthOfLastWord(String s) {
        int i,l=0,m=0;
        for(i=0;i<s.length();i++)
        if(s.charAt(i)==' ') 
        {
            if(l!=0) m=l;
            l=0;
        }
        else l++;
        if(l!=0) m=l;
        return m;
    }
}
