class Solution {
    public boolean isValidSerialization(String pre) {
        if(pre.length()==1) return pre.charAt(0)=='#';
        String s[]=pre.split(",");
        if(s.length% 2==0) return false;
        
        Stack<Integer> st=new Stack<>();
        for(String x:s) 
        if(x.equals("#"))
        {
            if(st.isEmpty()) return false;
            int cur=st.pop()+1;
            if(cur<2) st.push(cur);
        } 
        else 
        {
            if(st.isEmpty()) st.push(0);
            else 
            {
                int cur=st.pop()+1;
                if(cur<2) st.push(cur);
                st.push(0);
            }
        }
        return st.isEmpty();
    }
}
