class Solution {
    public int maxNumberOfFamilies(int n, int[][] reserved) {
        
        Arrays.sort(reserved, new Comparator<int []>()
        {
        public int compare(final int[] c1,final int[] c2)
        {
            if(c1[0]>=c2[0]) return 1;
            else return -1;
        }
        });
        
        int c=0,x,i,j,t=0;
        ArrayList<Integer> nu=new ArrayList<>();
        int y[]=new int[10];
        y[reserved[0][1]-1]=1;
        x=reserved[0][0];
        
        for(i=1;i<reserved.length;i++)
        {
            if(reserved[i][0]==x) y[reserved[i][1]-1]=1;
            else
            {
                t=0;
                if(y[1]==0 && y[2]==0 && y[3]==0 && y[4]==0) {t++;c++;}
                if(y[5]==0 && y[6]==0 && y[7]==0 && y[8]==0) {t++;c++;}
                if(t==0 && y[3]==0 && y[4]==0 && y[5]==0 && y[6]==0) c++;
                nu.add(x);
                x=reserved[i][0];
                for(j=0;j<10;j++) y[j]=0;
                y[reserved[i][1]-1]=1;
            }
        }
        t=0;
        if(y[1]==0 && y[2]==0 && y[3]==0 && y[4]==0) {t++;c++;}
        if(y[5]==0 && y[6]==0 && y[7]==0 && y[8]==0) {t++;c++;}
        if(t==0 && y[3]==0 && y[4]==0 && y[5]==0 && y[6]==0) c++;
        nu.add(x);
        c+=2*(n-nu.size());        
        return c;
    }
}
