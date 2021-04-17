class Solution {
    public String removeDuplicates(String s, int k) {
        int i,n=s.length(),l=0,c=s.charAt(0);
        Deque<Pair> dq=new LinkedList<>();
        for(i=0;i<n;i++)
        if(s.charAt(i)==c) l++;
        else
        {
            l%=k;
            while(!dq.isEmpty() && dq.peekLast().c==c)
            {
                l+=dq.pollLast().v;
                l%=k;
            }
            if(l!=0) dq.addLast(new Pair(c,l));
            c=s.charAt(i);
            l=1;
        }
        
        l%=k;
        while(!dq.isEmpty() && dq.peekLast().c==c)
        {
            l+=dq.pollLast().v;
            l%=k;
        }
        if(l!=0) dq.addLast(new Pair(c,l));
       
        StringBuilder ans=new StringBuilder();
        while(!dq.isEmpty())
        {
            Pair p=dq.pollFirst();
            while(p.v!=0)
            {
                ans.append((char)p.c);
                p.v--;
            }
        }
        return ans.toString();
    }
    
    class Pair
    {
        int c,v;
        Pair(int a,int b)
        {
            c=a;
            v=b;
        }
    }
}
