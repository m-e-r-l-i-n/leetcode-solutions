class Solution {
    public List<String> stringMatching(String[] w) {
        int i,j;
        List<String> ans=new ArrayList<>();
        for(i=0;i<w.length;i++)
            for(j=0;j<w.length;j++)
            {
                if(i==j) continue;
                if(w[j].contains(w[i])) {ans.add(w[i]); break;}
            }
        return ans;
    }
}
