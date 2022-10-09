class Solution {
    public boolean equalFrequency(String word) {
        int c[]=new int[26],i,max=0;
        for(i=0;i<word.length();i++)
        {
            c[word.charAt(i)-'a']++;
            max=Math.max(max,c[word.charAt(i)-'a']);
        }
        
        for(i=0;i<26;i++)
        if(c[i]!=0)
        {
            int j,cur=-1;
            c[i]--;
            for(j=0;j<26;j++)
            {
                if(cur==-1 && c[j]!=0) cur=c[j];
                if(c[j]!=0 && c[j]!=cur) break;
            }
            c[i]++;
            if(j==26) return true;
        }
        return false;
    }
}
