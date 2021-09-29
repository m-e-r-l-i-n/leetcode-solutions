class Solution {
    public int scoreOfStudents(String s, int[] a) {
        v=new ArrayList<>();
        op=new ArrayList<>();
        int i,n=s.length(),cur=0;
        for(i=0;i<n;i++)
        if(s.charAt(i)=='+' || s.charAt(i)=='*')
        {
            v.add(cur);
            cur=0;
            op.add(s.charAt(i));
            v.add(-op.size());
        }
        else cur=10*cur+s.charAt(i)-'0';
        v.add(cur);
        
        n=v.size();
        dp=new HashSet[n][n];
        for(i=0;i<n;i++)
        for(int j=0;j<n;j++) dp[i][j]=new HashSet<>();
        ways(0,n-1);
        boolean all[]=new boolean[N+1];
        for(int x:dp[0][n-1]) all[x]=true;
        
        Deque<Integer> dq=new LinkedList<>();
        for(i=0;i<n;i++)
        if(v.get(i)>=0) dq.addLast(v.get(i));
        else
        {
            char c=op.get(-v.get(i)-1);
            if(c=='+') continue;
            int val=dq.pollLast();
            val*=v.get(i+1);
            dq.addLast(val);
            i++;
        }
        int act=0;
        while(!dq.isEmpty()) act+=dq.pollFirst();
        
        int sc=0;
        for(int x:a)
        if(x==act) sc+=5;
        else if(all[x]) sc+=2;
        return sc;
    }
    
    ArrayList<Integer> v;
    Set<Integer> dp[][];
    ArrayList<Character> op;
    int N=1000;
    void ways(int l,int r)
    {
        if(dp[l][r].size()!=0) return;
        int i;
        for(i=l;i<=r;i++)
        if(v.get(i)<0)
        {
            ways(l,i-1); ways(i+1,r);
            char o=op.get(-v.get(i)-1);
            for(int x:dp[l][i-1])
            for(int y:dp[i+1][r])
            if(o=='+' && x+y<=N) dp[l][r].add(x+y);
            else if(o=='*' && x*y<=N) dp[l][r].add(x*y);
        }
        if(dp[l][r].size()==0) dp[l][r].add(v.get(l));
    }
}
