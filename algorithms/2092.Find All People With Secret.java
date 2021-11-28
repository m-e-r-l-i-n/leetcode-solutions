//Tamonash Chakraborty
//O(nlogn)
class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int o1[],int o2[])
            {
                if(o1[0]>o2[0]) return 1;
                else return -1;
            }});
        //we will sort meeting times with this
        
        int cur=0,i;
        pq.add(new int[]{0,0,firstPerson});
        for(int x[]:meetings)   //find maximum possible value of n
        {
            pq.add(new int[]{x[2],x[0],x[1]});    
        }
        
        Queue<Integer> g[]=new LinkedList[n],q=new LinkedList<>();
        boolean secret[]=new boolean[n];    //who know the secrets
        secret[0]=true;
        for(i=0;i<n;i++) g[i]=new LinkedList<>();   //need this when we will be spreading secrets
        
        while(!pq.isEmpty())
        {
            while(!pq.isEmpty() && pq.peek()[0]==cur)   //current time
            {
                int u[]=pq.poll();
                g[u[1]].add(u[2]); g[u[1]].add(u[0]);   //add time as well
                g[u[2]].add(u[1]); g[u[2]].add(u[0]);
                if(secret[u[1]]) q.add(u[1]);
                if(secret[u[2]]) q.add(u[2]);
            }
            
            while(!q.isEmpty()) //perform multisource BFS based on the people who know secrets 
            {
                int p=q.poll();
                while(!g[p].isEmpty())  //this is to ensure same edges are not looped multiple times
                {
                    int u=g[p].poll(),ti=g[p].poll();
                    if(ti<cur) continue;    //there may be redundant edges present
                    if(!secret[u])
                    {
                        secret[u]=true;
                        q.add(u);
                    }
                }
            }
            
            if(!pq.isEmpty()) cur=pq.peek()[0]; //update current time
        }
        
        List<Integer> ans=new ArrayList<>();
        for(i=0;i<n;i++)
        if(secret[i]) ans.add(i);
        return ans;
    }
}
