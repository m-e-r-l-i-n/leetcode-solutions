class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n=s1.length(),m=s2.length(),o=s3.length(),i,j;
        if(n+m!=o) return false;
        Queue<Integer> q=new LinkedList<>();
        HashMap<Integer,Set<Integer>> hm=new HashMap<>();
        Set<Integer> st=new HashSet<>();
        st.add(0);
        hm.put(0,st);
        q.add(0); q.add(0);
        
        while(!q.isEmpty())
        {
            int x=q.poll(),y=q.poll();
            if(x+y==o) return true;
            if(x+1<=n && s1.charAt(x)==s3.charAt(x+y) && (hm.get(x+1)==null || !hm.get(x+1).contains(y)))
            {
                q.add(x+1); q.add(y);
                st=new HashSet<>();
                if(hm.get(x+1)==null) hm.put(x+1,st);
                hm.get(x+1).add(y);
            }
            if(y+1<=m && s2.charAt(y)==s3.charAt(x+y) && (hm.get(x)==null || !hm.get(x).contains(y+1)))
            {
                q.add(x); q.add(y+1);
                st=new HashSet<>();
                if(hm.get(x)==null) hm.put(x,st);
                hm.get(x).add(y+1);
            }
            
        }
        return false;
    }
}
