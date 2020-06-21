class Solution {
    public String[] getFolderNames(String[] names) {
        int i,n=names.length;
        String ans[]=new String[n];
        HashMap<String,Integer> hm=new HashMap<>();
        for(i=0;i<n;i++)
        {
            if(hm.get(names[i])==null)
            {
                hm.put(names[i],1);
                ans[i]=names[i];
            }
            else
            {
                int v=hm.get(names[i]);
                ans[i]=names[i]+'('+v+')';
                while(hm.get(ans[i])!=null)
                {
                    v++;
                    ans[i]=names[i]+'('+v+')';
                }
                hm.put(ans[i],1);
                hm.put(names[i],v+1);
            }
        }
        return ans;
    }
    
}
