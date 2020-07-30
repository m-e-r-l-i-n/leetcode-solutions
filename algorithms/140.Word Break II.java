class Solution 
{
    HashMap<String,List<String>> hm=new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) 
    {
        List<String> res=new ArrayList<>();
        if(s==null || s.length()==0) return res;
        if(hm.get(s)!=null) return hm.get(s);
        if(wordDict.contains(s)) res.add(s);
        
        
        int i,j;
        for(i=1;i<s.length();i++) 
        {
            String t=s.substring(i);
            if(wordDict.contains(t)) 
            {
                List<String> temp=wordBreak(s.substring(0,i),wordDict);
                if(temp.size()!=0) 
                for(j=0;j<temp.size();j++) 
                    res.add(temp.get(j) + " " + t);
            }
        }
        hm.put(s,res);
        return res;
    }
}
