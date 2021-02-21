class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb=new StringBuilder();
        int i,n=s.length(); boolean vis[]=new boolean[n];
        Stack<Integer> st=new Stack<>();
        for(i=0;i<n;i++)
        if(s.charAt(i)=='(') st.push(i);
        else if(s.charAt(i)==')')
        {
            if(!st.isEmpty()) 
            {
                vis[st.pop()]=true;
                vis[i]=true;
            }
        }
        else vis[i]=true;
        
        for(i=0;i<n;i++)
        if(vis[i]) sb.append(s.charAt(i));
        return sb.toString();
    }
}
