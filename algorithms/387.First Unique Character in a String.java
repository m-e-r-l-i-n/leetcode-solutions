class Solution {
    public int firstUniqChar(String s) {
       int i,m[]=new int[26];
        for(i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(m[c-'a']==0) m[c-'a']=(i+1);
            else m[c-'a']-=(i+1);
        }
        int min=Integer.MAX_VALUE;
        for(i=0;i<26;i++)
            if(m[i]>0 && m[i]<min) min=m[i];
        if(min==Integer.MAX_VALUE) return -1;
        else return min-1;
    }
}
