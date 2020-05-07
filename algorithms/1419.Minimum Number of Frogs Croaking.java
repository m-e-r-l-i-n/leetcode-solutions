class Solution {
    public int minNumberOfFrogs(String cr) {
        int c[]=new int[5],l=cr.length(),i,max=0;
        for(i=0;i<l;i++)
        {
            char ch=cr.charAt(i);
            if(ch=='c') c[0]++;
            else if(ch=='r')
            {
                if(c[0]<1) return -1;
                c[0]--; c[1]++;
            }
            else if(ch=='o')
            {
                if(c[1]<1) return -1;
                c[1]--; c[2]++;
            }
            else if(ch=='a')
            {
                if(c[2]<1) return -1;
                c[2]--; c[3]++;
            }
            else
            {
                if(c[3]<1) return -1;
                c[3]--; c[4]++;
            }
            if(c[0]+c[1]+c[2]+c[3]+c[4]>max) max=c[0]+c[1]+c[2]+c[3]+c[4];
            c[4]=0;
        }
        if(c[0]>0 || c[1]>0 || c[2]>0 || c[3]>0 || c[4]>0) return -1;
        else return max;
    }
}
