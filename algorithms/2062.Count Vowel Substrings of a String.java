//Tamonash Chakraborty
//O(n^2)
class Solution {
    public int countVowelSubstrings(String word) {
        int i,j,ans=0,n=word.length();
        boolean v[]=new boolean[26];
        v[0]=v['e'-'a']=v['i'-'a']=v['o'-'a']=v['u'-'a']=true;	//mark the vowels
        for(i=0;i<n;i++)
        {
            boolean c[]=new boolean[26];
            for(j=i;j<n;j++)
            if(v[word.charAt(j)-'a'])
            {
                c[word.charAt(j)-'a']=true;	//which characters are being visited
                if(c[0] && c['e'-'a'] && c['i'-'a'] && c['o'-'a'] && c['u'-'a']) ans++;	//all vowels present
            }
            else break;	//there can be no consonant present in the substring
        }
        return ans;
    }
}
