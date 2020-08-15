class Solution {
    public int eraseOverlapIntervals(int[][] a) {
        int i,c=0,end=Integer.MIN_VALUE;
        Arrays.sort(a,new Comparator<int[]>(){
            public int compare(int o1[],int o2[])
            {
                if(o1[1]>o2[1]) return 1;
                else if(o1[1]==o2[1]) return o1[0]>o2[0]?1:-1;
                else return -1;
            }});
        for(i=0;i<a.length;i++)
        if(a[i][0]>=end) end=a[i][1];
        else c++;
        return c;
    }
}
