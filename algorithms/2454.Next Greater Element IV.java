class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int i,n=nums.length,ans[]=new int[n];
        ArrayList<Integer> g[]=new ArrayList[n],al=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(i=n-1;i>=0;i--)
        {
            g[i]=new ArrayList<>();
            ans[i]=-1;
            
            while(!stack.isEmpty() && nums[stack.peek()]<=nums[i]) stack.pop();
            if(!stack.isEmpty()) g[stack.peek()].add(i);    //next higher
            stack.add(i);
            
            if(hm.get(nums[i])==null)
            {
                hm.put(nums[i],0);
                al.add(nums[i]);
            }
        }
        
        Collections.sort(al);
        i=0;
        int sz=al.size();
        st=new int[4*sz];
        Arrays.fill(st,Integer.MAX_VALUE);
        for(int x:al) hm.put(x,i++);
        
        for(i=n-1;i>=0;i--)
        {
            for(int x:g[i])
            {
                int q=query(0,sz-1,hm.get(nums[x])+1,sz-1,0);
                if(q<n) ans[x]=nums[q];
            }
            update(0,sz-1,hm.get(nums[i]),i,0);
        }
        return ans;
    }
    
    int st[];
    void update(int ss,int se,int i,int v,int n)
    {
        if(ss>se) return;
        if(ss==se)
        {
            st[n]=v;
            return;
        }
        
        int m=(ss+se)>>1;
        if(i<=m) update(ss,m,i,v,2*n+1);
        else update(m+1,se,i,v,2*n+2);
        st[n]=Math.min(st[2*n+1],st[2*n+2]);
    }
    
    int query(int ss,int se,int qs,int qe,int n)
    {
        if(ss>se || qs>qe || qs>se || qe<ss) return Integer.MAX_VALUE;
        if(qs<=ss && qe>=se) return st[n];
        
        int m=(ss+se)>>1;
        return Math.min(query(ss,m,qs,qe,2*n+1),query(m+1,se,qs,qe,2*n+2));
    }
}
