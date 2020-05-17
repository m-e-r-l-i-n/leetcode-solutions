class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int cp[]=new int[26],c[][]=new int[s.length()+1][26],i,j;
        for(i=0;i<p.length();i++)
            cp[p.charAt(i)-'a']++;
        ArrayList<Integer> al=new ArrayList<>();
        for(i=1;i<=s.length();i++)
        {
            c[i][s.charAt(i-1)-'a']++;
            for(j=0;j<26;j++)
            c[i][j]+=c[i-1][j];
            if(i-p.length()>=0)
            {
                int f=0;
                for(j=0;j<26;j++)
                if((c[i][j]-c[i-p.length()][j])!=cp[j]) {f=1; break;}
                if(f==0) al.add(i-p.length());
            }
        }
        return al;
    }
}
