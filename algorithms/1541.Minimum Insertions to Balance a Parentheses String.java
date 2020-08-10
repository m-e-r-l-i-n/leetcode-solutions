class Solution {
    public int minInsertions(String s) {
        int i,n=s.length(),no=0,ri=0;
        for(i=0;i<n;i++)
        {
            if(s.charAt(i)=='(') 
            {
                if(ri%2!=0)
                {ri--; no++;}
                ri+=2;
            }
            else
            {
                ri--;
                if(ri<0) {ri+=2; no++;}
            }
        }
        return no+ri;
    }
}
