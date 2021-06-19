class Solution {
    public List<String> generateParenthesis(int n) {
        v=new boolean[2*n];
        generate(0,2*n);
        return ans;
    }
    
    boolean v[];
    List<String> ans=new ArrayList<>();
    void generate(int x,int n)
    {
        int i;
        if(x==n)
        {
            int c=0;
            for(i=0;i<n;i++)
            {
                c+=v[i]?1:-1;
                if(c<0) return;
            }
            
            if(c==0)
            {
                String s="";
                for(i=0;i<n;i++)
                if(v[i]) s+='(';
                else s+=')';
                ans.add(s);
            }
            return;
        }
        
        v[x]=true;
        generate(x+1,n);
        v[x]=false;
        generate(x+1,n);
    }
}
