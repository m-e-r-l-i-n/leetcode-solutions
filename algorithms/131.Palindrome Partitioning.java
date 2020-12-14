class Solution {
    boolean p[][];
    public List<List<String>> partition(String s) {
        int n=s.length(),i,j;
        p=new boolean[n][n];
        for(i=0;i<n;i++)
        p[i][i]=true;
        
        for(i=2;i<=n;i++)
        for(j=0;j<n-i+1;j++)
        {
            int end=j+i-1;
            if(i==2) p[j][end]=(s.charAt(j)==s.charAt(end));
            else p[j][end]=(s.charAt(j)==s.charAt(end)) & p[j+1][end-1];
        }
        
        List<List<String>> res=new ArrayList<>();
        partitions(s,res,new Stack<String>(),0);
        return res;
    }
    
    void partitions(String s,List<List<String>> res,Stack<String> st,int begin)
    {
        if(begin>=s.length())   
        {
            Iterator<String> it=st.iterator();
            List<String> tem=new ArrayList<>();
            while(it.hasNext())
                tem.add(it.next());
            res.add(tem);
            return;
        }

        for(int i=begin;i<s.length();i++)
        if(p[begin][i]) 
        {
            st.add(s.substring(begin,i+1));
            partitions(s,res,st,i+1);
            st.pop();
        }
    }
}
