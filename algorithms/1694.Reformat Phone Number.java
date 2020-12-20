class Solution {
    public String reformatNumber(String s) {
        Queue<Character> q=new LinkedList<>();
        int i,n=s.length();
        for(i=0;i<n;i++)
        if(s.charAt(i)>='0' && s.charAt(i)<='9') q.add(s.charAt(i));
        
        String ans="";
        while(q.size()>4)
        {
            ans+=q.poll();
            ans+=q.poll();
            ans+=q.poll();
            ans+='-';
        }
        if(q.size()==4)
        {
            ans+=q.poll();
            ans+=q.poll();
            ans+='-';
            ans+=q.poll();
            ans+=q.poll();
        }
        else 
        {
            while(!q.isEmpty())
            ans+=q.poll(); 
        }
        return ans;
    }
}
