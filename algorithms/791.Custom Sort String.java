class Solution {
    public String customSortString(String order, String s) {
        StringBuilder ans=new StringBuilder();
        int i,j,n=s.length(); boolean v[]=new boolean[n];
        for(i=0;i<order.length();i++)
        {
            char c=order.charAt(i);
            for(j=0;j<n;j++)
            if(s.charAt(j)==c) {ans.append(c); v[j]=true;}    
        }
        
        for(i=0;i<n;i++)
        if(!v[i]) ans.append(s.charAt(i));
        return ans.toString();
    }
}
