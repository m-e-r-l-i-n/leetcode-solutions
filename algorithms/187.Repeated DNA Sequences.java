class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String,Integer> hm=new HashMap<>();
        int i,n=s.length();
        for(i=0;i<n;i++)
        if(i+10<=n) 
        {
            String st=s.substring(i,i+10);
            hm.put(st,hm.getOrDefault(st,0)+1);
        }
        List<String> ans=new ArrayList<>();;
        for(String x:hm.keySet())
        if(hm.get(x)>1) ans.add(x);
        return ans;
    }
}
