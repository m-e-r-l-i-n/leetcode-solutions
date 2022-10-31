class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans=new ArrayList<>();
        for(String x:queries)
        {
            boolean ok=false;
            for(String y:dictionary)
            {
                int i,l=x.length(),g=0;
                for(i=0;i<l;i++)
                {
                    if(x.charAt(i)!=y.charAt(i)) g++;
                    if(g>2) break;
                }
                if(g<=2) {ok=true; break;} 
            }
            if(ok) ans.add(x);
        }
        return ans;
    }
}
