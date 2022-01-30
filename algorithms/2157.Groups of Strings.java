//Tamonash Chakraborty
//O(26*26*n)
class Solution {
    public int[] groupStrings(String[] words) {
        HashMap<Integer,Integer> sz=new HashMap<>();    //number of elements of a particular key
        HashMap<Integer,Set<Integer>> g=new HashMap<>();    //graph
        
        for(String x:words)
        {
            int key=0,i,l=x.length();
            for(i=0;i<l;i++) key|=1<<(x.charAt(i)-'a');
            
            sz.put(key,sz.getOrDefault(key,0)+1);   //number of elements of this particular key
            if(g.get(key)==null) g.put(key,new HashSet<>());    //node for the graph
            
            for(i=0;i<26;i++)
            {
                int key2=key^(1<<i);    //either adding or deleting a letter
                if(sz.get(key2)!=null)
                {
                    g.get(key).add(key2);   //add an edge
                    g.get(key2).add(key);   
                }
                if(((key>>i)&1)==0) continue;   //we cannot replace a character that doesn't exist
            
                //now we need to replace a character
                //key2 already has a character removed
                for(int j=0;j<26;j++)
                if(j!=i && ((key2>>j)&1)==0)    //we do not need same changes
                {
                    key2|=1<<j; //add a new character
                    if(sz.get(key2)!=null)
                    {
                        g.get(key).add(key2);
                        g.get(key2).add(key);
                    }
                    key2^=1<<j; //remove the character
                }    
            }    
        }
        
        Queue<Integer> q=new LinkedList<>();
        int ans[]={0,0};
        //perform bfs
        for(int x:sz.keySet())
        {
            int v=sz.get(x);
            if(v<0) continue;   //visited node
            int cur=v;
            sz.put(x,-v);
            q.add(x);
            
            while(!q.isEmpty())
            {
                int p=q.poll();
                for(int y:g.get(p))
                {
                    v=sz.get(y);
                    if(v>0)
                    {
                        sz.put(y,-v);
                        cur+=v;
                        q.add(y);
                    }
                }
            }
            
            ans[0]++; ans[1]=Math.max(ans[1],cur);
        }
        return ans;
    }
}
