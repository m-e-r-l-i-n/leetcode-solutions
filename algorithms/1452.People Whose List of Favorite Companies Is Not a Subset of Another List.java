class Solution {
    public List<Integer> peopleIndexes(List<List<String>> fav) {
        int n=fav.size(),i,j;
        HashMap<Integer,HashSet<String>> hm=new HashMap<>();
        for(i=0;i<n;i++) 
        {
            hm.put(i, new HashSet<>());
            for(j=0;j<fav.get(i).size();j++) 
            hm.get(i).add(fav.get(i).get(j));
        }
        List<Integer> ans=new ArrayList<>();
        for(i=0;i<n;i++) 
        {
            boolean f2=true;
            for(j=0;j<n;j++) 
            {
                if(i==j) continue;
                HashSet<String> s1=hm.get(i);
                HashSet<String> s2=hm.get(j);
                Iterator<String> it=s1.iterator();
                boolean flag=false;
                while(it.hasNext())
                if(!s2.contains(it.next())) 
                {flag=true; break;}
                if(!flag) {f2=false; break;}
            }
            if(f2) ans.add(i);
        }
        return ans;
    }
}
