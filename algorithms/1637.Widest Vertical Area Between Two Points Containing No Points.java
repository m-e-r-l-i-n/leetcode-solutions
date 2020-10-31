class Solution {
    public int maxWidthOfVerticalArea(int[][] p) {
        Arrays.sort(p,new Comparator<int[]>(){
            public int compare(int o1[],int o2[])
            {
                if(o1[0]>o2[0]) return 1;
                else if(o1[0]==o2[0]) return o1[1]>o2[1]?1:-1;
                else return -1;
            }});
        
        int max=0,i,n=p.length;
        for(i=1;i<n;i++)
        max=Math.max(max,p[i][0]-p[i-1][0]);
        return max;
    }
}
