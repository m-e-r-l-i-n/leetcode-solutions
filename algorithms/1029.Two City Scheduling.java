class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs,new Comparator<int[]>(){
            public int compare(int e1[],int e2[])
            {
                if(e1[0]-e1[1]>e2[0]-e2[1]) return 1;
                else return -1;
            }});
        int res=0,i;
        for(i=0;i<costs.length;i++)
        if(i<costs.length/2) res+=costs[i][0];
        else res+=costs[i][1];
        return res;        
    }
}
