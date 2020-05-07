class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n=strs.length,i,j;
        HashMap<String,ArrayList<String>> c=new HashMap<>();
        for(i=0;i<n;i++)
        {
            char ch[]=strs[i].toCharArray();
            Arrays.sort(ch);
            String s=new String(ch);
            if(c.containsKey(s))
            {
                ArrayList<String> t=c.get(s);
                t.add(strs[i]);
                c.remove(s);
                c.put(s,t);
            }
            else
            {
                ArrayList<String> t=new ArrayList<>();
                t.add(strs[i]);
                c.put(s,t);
            }
            
        }
        
        List<List<String>> l=new ArrayList<>();
        for(String x:c.keySet())
        {
            ArrayList<String> t=c.get(x);
            l.add(t);
        }
        
        return l;
    }
}
