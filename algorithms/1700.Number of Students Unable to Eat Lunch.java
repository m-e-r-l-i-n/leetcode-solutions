class Solution {
    public int countStudents(int[] a, int[] b) 
    {
        Stack<Integer> s=new Stack<>();
        Queue<Integer> q=new LinkedList<>();
        int i,n=a.length,c[]=new int[2];
        for(i=n-1;i>=0;i--)
        s.push(b[i]);
        for(i=0;i<n;i++)
        {
            q.add(a[i]);
            c[a[i]]++;
        }
        
        while(!q.isEmpty() && !s.isEmpty())
        {
            int cn=0;
            while(s.peek()!=q.peek() && cn<q.size()) 
            {
                cn++;
                q.add(q.poll());
            }
            if(cn==q.size()) break;
            s.pop();
            q.poll();
        }
        return q.size();
    }
}
