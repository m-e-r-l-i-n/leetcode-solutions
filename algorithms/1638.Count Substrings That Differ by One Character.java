class Solution {
    public int countSubstrings(String s, String t) {
        int i,j,k,l,ans=0,n=s.length(),m=t.length();
        HashMap<String,Integer> hm=new HashMap<>();
        for(i=0;i<n;i++)
        for(j=i+2;j<=n;j++)
        {
            String x=s.substring(i,j);
            int val=hm.getOrDefault(x,0);
            val++;
            hm.put(x,val);
            
        }
        int c[]=new int[26],c2[]=new int[26];
        for(i=0;i<n;i++)
        c[s.charAt(i)-'a']++;
        for(i=0;i<m;i++)
        c2[t.charAt(i)-'a']++;
        
        for(i=0;i<26;i++)
        if(c[i]==0) continue;
        else if(m-c2[i]>0) ans+=c[i]*(m-c2[i]);
        for(String x:hm.keySet())
        {
            int found=0;
            j=x.length();
            for(i=0;i+j<=m;i++)
            {
                l=0;
                for(k=0;k<j;k++)
                {
                    if(x.charAt(k)!=t.charAt(i+k)) l++;
                    if(l>1) break;
                }
                if(l==1) found++;
            } 
            ans+=hm.get(x)*found;
        }
        return ans;
    }
}
