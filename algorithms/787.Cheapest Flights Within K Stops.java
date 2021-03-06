class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) 
    {
        HashMap<Integer,HashMap<Integer,Integer>> prices=new HashMap<>();
        for(int[] f:flights) 
        {
            if(prices.get(f[0])==null) prices.put(f[0],new HashMap<>());
            prices.get(f[0]).put(f[1],f[2]);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(Integer.compare(a[0], b[0])));
        pq.add(new int[] {0,src,K+1});
        while(!pq.isEmpty()) 
        {
            int top[]=pq.remove(),price=top[0],city=top[1],stops=top[2];
            if(city==dst) return price;
            if(stops>0) 
            {
                HashMap<Integer,Integer> adj=prices.getOrDefault(city,new HashMap<>());
                for(int a:adj.keySet()) 
                    pq.add(new int[] {price+adj.get(a),a,stops-1});
            }
        }
        return -1;
        
    }
}
