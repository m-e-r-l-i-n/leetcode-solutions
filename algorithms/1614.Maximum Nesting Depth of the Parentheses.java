class Solution {
    public int maxDepth(String s) {
        int n=s.length(),i,c1[]=new int[n];
        Stack<Integer> st=new Stack();
        for(i=0;i<n;i++)
        if(s.charAt(i)=='(') 
        {
            c1[i]=st.size();
            st.push(i);
        }
        else if(s.charAt(i)==')')
        {
            c1[i]=st.size();
            if(!st.isEmpty()) st.pop();
        }
        else c1[i]=st.size();
        
        st=new Stack(); int c2[]=new int[n];
        for(i=n-1;i>=0;i--)
        if(s.charAt(i)==')') 
        {
            st.push(i);
            c2[i]=st.size();
        }
        else if(s.charAt(i)=='(')
        {
            c2[i]=st.size();
            if(!st.isEmpty()) st.pop();
        }
        else c2[i]=st.size();
        
        int ans=0;
        for(i=0;i<n;i++)
        ans=Math.max(ans,Math.min(c1[i],c2[i]));
        return ans;
    }
}
