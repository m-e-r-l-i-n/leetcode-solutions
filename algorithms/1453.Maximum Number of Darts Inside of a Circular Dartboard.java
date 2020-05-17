class Solution {
    public int numPoints(int[][] p, int r) {
        int i,j,max=0,n=p.length;
        double dis[][]=new double[n][n];
        for(i=0;i<n;i++)
        for(j=i+1;j<n;j++)
            dis[i][j]=dis[j][i]=Math.sqrt(Math.pow(p[j][0]-p[i][0],2)+Math.pow(p[j][1]-p[i][1],2));
        for(i=0;i<n;i++)
            max=Math.max(max,getpoints(i,r,n,dis,p));
        return max;
    }
    int getpoints(int i,int r,int n,double d[][],int p[][])
    {
        int j;
        ArrayList<Pair> al=new ArrayList<>();
        for(j=0;j<n;j++)
        if(i!=j && d[i][j]<=2.0*r)
        {
            double b=Math.acos(d[i][j]/(2*r)),a=Math.atan2(p[j][1]-p[i][1],p[j][0]-p[i][0]);
            al.add(new Pair(a-b,true));
            al.add(new Pair(a+b,false));
        }
        Collections.sort(al,new Comparator<Pair>(){
            public int compare(Pair o1,Pair o2)
            {
                if(o1.x>o2.x) return 1;
                else if(o1.x==o2.x)
                {
                    if(o1.y==false) return 1;
                    else return -1;
                }
                else return -1;
            }});
        int ans=1,c=1;
        for(j=0;j<al.size();j++)
        {
            if(al.get(j).y) c++;
            else c--;
            ans=Math.max(ans,c);
        }   
        return ans;
    }
    class Pair
    {
        double x;
        boolean y;
        Pair(double a,boolean b)
        {
            x=a;
            y=b;
        }
    }
}
