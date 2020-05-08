class Solution {
    public String stringShift(String s, int[][] shift) {
        int c=0,i;
        for(i=0;i<shift.length;i++)
        if(shift[i][0]==1) c-=shift[i][1];
        else c+=shift[i][1];
        String st="";
        if(c==0) return s;
        else if(c>0)
        {
            c=c%s.length();
            st=s.substring(c)+s.substring(0,c);
        }
        else 
        {
            c=-c%s.length();
            st=s.substring(s.length()-c)+s.substring(0,s.length()-c);
        }
        return st;
    }
}
