class Solution {
    public int findLUSlength(String[] strs) {
        int n=strs.length,i,j;
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();
            }});
        
        Set<String> dup=new HashSet<>(),set=new HashSet<>();
        for(String s:strs)
        {
            if(set.contains(s)) dup.add(s);
            set.add(s);
        }
        
        for(i=0;i<n;i++)
        if(!dup.contains(strs[i])) 
        {
            if(i==0) return strs[0].length();
            for(j=0;j<i; j++) 
            if(checksub(strs[i],strs[j])) break;
            if(j==i) return strs[i].length();
        }
        return -1;
    }
    
    boolean checksub(String a,String b)
    {
        int n=a.length(),m=b.length();
        if(n>m) return false;
        int i,j=0;
        for(i=0;i<m;i++)
        {
            if(a.charAt(j)==b.charAt(i)) j++;
            if(j==n) return true;
        }
        return false;
    }
}
