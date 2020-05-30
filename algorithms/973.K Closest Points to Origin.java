class Solution {
    public int[][] kClosest(int[][] points, int K) {
        double p[][]=new double[points.length][3];
        int i;
        for(i=0;i<points.length;i++)
        {
            p[i][0]=points[i][0];
            p[i][1]=points[i][1];
            p[i][2]=Math.sqrt(p[i][0]*p[i][0]+p[i][1]*p[i][1]);
        }    
        Arrays.sort(p,new Comparator<double[]>(){
            public int compare(double e1[],double e2[])
            {
                if(e1[2]>e2[2]) return 1;
                else return -1;
            }});
        int ans[][]=new int[K][2];
        for(i=0;i<K;i++)
        {ans[i][0]=(int)p[i][0];
        ans[i][1]=(int)p[i][1];}
        return ans;
    }
}
