class Solution {
    public int[] avoidFlood(int[] rains) {
        int n=rains.length,i,ans[]=new int[n],flag=0,min=-1;
        Queue<Integer> q=new LinkedList<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        HashMap<Integer,Integer> fill=new HashMap<>();
        for(i=0;i<n;i++)
        {
            ans[i]=-2;
            if(rains[i]==0) {q.add(i); continue;}
            if(hm.get(rains[i])==null)
            {
                ans[i]=-1;
                hm.put(rains[i],1);
                fill.put(rains[i],i);
                if(min==-1) min=rains[i];
            }
            else if(hm.get(rains[i])==0)
            {
                ans[i]=-1;
                hm.put(rains[i],1);
                fill.put(rains[i],i);
            }
            else
            {
                int af=fill.get(rains[i]);
                ArrayList<Integer> te=new ArrayList<>();
                while(!q.isEmpty() && q.peek()<af) te.add(q.poll());
                if(q.isEmpty()) {flag=1; break;}
                int top=q.poll();
                ans[top]=rains[i];
                ans[i]=-1;
                for(int x:te) q.add(x);
                fill.put(rains[i],i);
            }
        }
        if(flag==1) return new int[0];
        for(i=0;i<n;i++)
        if(ans[i]==-2) ans[i]=min;
        return ans;
    }
}
