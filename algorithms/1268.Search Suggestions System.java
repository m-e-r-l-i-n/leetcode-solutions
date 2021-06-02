class Solution {
    public List<List<String>> suggestedProducts(String[] p, String s) {
        List<List<String>> ans=new ArrayList<>();
        int i,j,n=s.length(),m=p.length;
        Arrays.sort(p);
        int vis[]=new int[m];
        Arrays.fill(vis,-1);
        for(i=0;i<n;i++)
        {
            List<String> l=new ArrayList<>();
            for(j=0;j<m;j++)
            if(i<p[j].length() && p[j].charAt(i)==s.charAt(i) && vis[j]==i-1)
            {
                vis[j]++;
                if(l.size()<3) l.add(p[j]);
            }
            ans.add(l);
        }
        return ans;
    }
}
