class Solution {
    public String sortVowels(String s) {
        boolean vowel[]=new boolean[130];
        String vowels="AEIOUaeiou";
        int i,c[]=new int[130];
        for(i=0;i<vowels.length();i++) vowel[vowels.charAt(i)]=true;
        
        for(i=0;i<s.length();i++)
        if(vowel[s.charAt(i)]) c[s.charAt(i)]++;
        
        int j=0;
        String t="";
        for(i=0;i<s.length();i++)
        if(vowel[s.charAt(i)])
        {
            while(c[j]==0) j++; //will stop at a vowel;
            t+=(char)j;
            c[j]--;
        }
        else t+=s.charAt(i);
        return t;
    }
}
