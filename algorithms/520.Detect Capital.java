class Solution {
    public boolean detectCapitalUse(String word) {
        int c=0,i;
        for(i=0;i<word.length();i++)
        if(word.charAt(i)>='A' && word.charAt(i)<='Z') c++;
        if(c==0 || c==word.length() || (c==1 && word.charAt(0)>='A' && word.charAt(0)<='Z')) return true;
        else return false;
    }
}
