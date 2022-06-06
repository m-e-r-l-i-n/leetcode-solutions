//Tamonash Chakraborty
//O(nlogn)
class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int i,c[]=new int[n]; //store number of edges attached to each node
        for(int x[]:roads)
        {
            c[x[0]]++;
            c[x[1]]++;
        }    
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(i=0;i<n;i++) pq.add(c[i]);
        
        long ans=0;
        for(i=1;i<=n;i++)
        ans+=1l*i*pq.poll();
        return ans;
    }
}
