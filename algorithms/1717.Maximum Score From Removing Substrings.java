class Solution {
    public int maximumGain(String str, int x, int y) {
        int n=str.length(),ans=0;
        char s[]=str.toCharArray();
        boolean v[]=new boolean[n];
        if(x>y)
        {
            ans+=ab(s,v,x);
            ans+=ba(s,v,y);
        }
        else
        {
            ans+=ba(s,v,y);
            ans+=ab(s,v,x);
        }
        return ans;
    }
    
    int ab(char s[],boolean v[],int a)
    {
        int i,n=s.length,ans=0;
        Stack<Integer> st=new Stack<>();
        for(i=0;i<n;i++)
        if(!v[i])
        {
            if(s[i]=='b' && !st.isEmpty() && s[st.peek()]=='a')
            {
                ans+=a;
                v[i]=true;
                v[st.peek()]=true;
                st.pop();
            }
            else st.push(i);
        }
        return ans;
    }
    
    int ba(char s[],boolean v[],int a)
    {
        int i,n=s.length,ans=0;
        Stack<Integer> st=new Stack<>();
        for(i=0;i<n;i++)
        if(!v[i])
        {
            if(s[i]=='a' && !st.isEmpty() && s[st.peek()]=='b')
            {
                ans+=a;
                v[i]=true;
                v[st.peek()]=true;
                st.pop();
            }
            else st.push(i);
        }
        return ans;
    }
}
