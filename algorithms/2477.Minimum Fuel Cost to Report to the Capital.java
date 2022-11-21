class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        int n=roads.length+1;
        ArrayList<Integer> g[]=new ArrayList[n];
        int i;
        for(i=0;i<n;i++) g[i]=new ArrayList<>();
        
        for(i=0;i<n-1;i++)
        {
            g[roads[i][0]].add(roads[i][1]);
            g[roads[i][1]].add(roads[i][0]);
        }
        
        ans=0;
        count_cars(g,0,-1,seats);
        return ans;
    }
    
    long ans;
    int count_cars(ArrayList<Integer> g[],int n,int p,int seats)
    {
        int child=1; 
        for(int x:g[n])
        if(x!=p)
        child+=count_cars(g,x,n,seats);
        
        int cars=child/seats;
        if(child%seats!=0) cars++;  //count cars needed to fit everyone
        if(n!=0) ans+=cars; //we are taking so many cars
        
        return child;
    }
}
