class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int c1[]=new int[26],c2[]=new int[26],i;
        for(i=0;i<ransomNote.length();i++)
            c1[ransomNote.charAt(i)-'a']++;
        for(i=0;i<magazine.length();i++)
            c2[magazine.charAt(i)-'a']++;
        boolean ans=true;
        for(i=0;i<26;i++)
            if(c1[i]>c2[i]) {ans=false; break;}
        return ans;
            
    }
}
