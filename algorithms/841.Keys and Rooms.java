class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> g) {
        int n=g.size();
        boolean v[]=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        q.add(0); v[0]=true;
        while(!q.isEmpty())
        {
            int p=q.poll();
            for(int x:g.get(p))
            if(!v[x])
            {
                v[x]=true;
                q.add(x);
            }
        }
        boolean ans=true;
        for(boolean x:v)
        ans&=x;
        return ans;
    }
}
