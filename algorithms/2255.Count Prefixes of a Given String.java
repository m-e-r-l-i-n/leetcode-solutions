//Tamonash Chakraborty
//O(n*s.length)
class Solution {
    public int countPrefixes(String[] words, String s) {
        int ans=0;
        for(String word:words)
        if(isPrefix(word,s)) ans++; 
        return ans;
    }
    
    boolean isPrefix(String a,String b) //check if a is a prefix of b
    {
        int i,n=a.length();
        if(n>b.length()) return false;
        for(i=0;i<n;i++)
        if(a.charAt(i)!=b.charAt(i)) return false;  //we need all characters to match
        return true;
    }
}
