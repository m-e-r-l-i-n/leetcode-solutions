class Solution {
    public String findLongestWord(String s, List<String> d) {
        int i,n=s.length();
        String ans="";
        for(i=0;i<d.size();i++)
        {
            String a=d.get(i);
            int j,c=0;
            if(a.length()>n) continue;
            for(j=0;j<n;j++)
            if(a.charAt(c)==s.charAt(j))
            {
                c++;
                if(c==a.length()) break;
            }
            if(c==a.length() && (c>ans.length() || (c==ans.length() && a.compareTo(ans)<0))) ans=a;
        }
        return ans;
    }
}
