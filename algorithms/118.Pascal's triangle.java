class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> l=new ArrayList<>();
        int i,j;
        for(i=0;i<numRows;i++)
        {
            ArrayList<Integer> al=new ArrayList<>();
            long c=1;
            al.add(1);
            for(j=1;j<=i;j++)
            {
                c=c*(i-j+1)/j;
                c%=1000000007l;
                al.add((int)c);
            }
            l.add(al);
        }
        return l;
        
    }
}
