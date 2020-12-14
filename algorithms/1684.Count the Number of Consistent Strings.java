class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean p[]=new boolean[26];
        int i,ans=0;
        for(i=0;i<allowed.length();i++)
            p[allowed.charAt(i)-'a']=true;
        
        for(i=0;i<words.length;i++)
        {
            int j; boolean pos=true;
            for(j=0;j<words[i].length();j++)
            if(!p[words[i].charAt(j)-'a']) {pos=false; break;}
            if(pos) ans++;
        }
        return ans;
    }
}
