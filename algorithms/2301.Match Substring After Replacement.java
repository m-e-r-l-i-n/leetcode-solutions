//Tamonash Chakraborty
//O(n*m) where n=s.length(),m=sub.length()
class Solution {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        Set<Character> set[]=new HashSet[200];
        int i;
        for(i=0;i<200;i++) set[i]=new HashSet<>();
        
        for(char x[]:mappings) set[x[0]].add(x[1]);
        int n=s.length(),m=sub.length(),j;
        for(i=0;i+m<=n;i++)
        {
            for(j=0;j<m;j++)
            if(s.charAt(i+j)==sub.charAt(j) || set[sub.charAt(j)].contains(s.charAt(i+j))) continue;
            else break;
            if(j==m) return true;
        }
        return false;
    }
}
