class Solution {
    public int numTimesAllBlue(int[] light) {
        int i,c=0,last=0;   //last stores position of last lighted bulb
        for(i=0;i<light.length;i++)
        {
            last=light[i]>last?light[i]:last;
            if(last==(i+1)) c++;    //all bulbs before it are lit
        }
        return c;
    }
}
