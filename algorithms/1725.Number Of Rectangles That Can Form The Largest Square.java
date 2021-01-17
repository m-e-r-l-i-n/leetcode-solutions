class Solution {
    public int countGoodRectangles(int[][] r) {
        int max=Integer.MIN_VALUE,c=0,i;
        for(i=0;i<r.length;i++)
        {
            int cur=Math.min(r[i][0],r[i][1]);
            if(cur==max) c++;
            else if(cur>max)
            {
                max=cur;
                c=1;
            }
        }
        return c;
    }
}
