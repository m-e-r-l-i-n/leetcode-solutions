class Solution {
    public List<List<Integer>> combinationSum(int[] c, int t) 
    {
        Arrays.sort(c); 
        int i,j;
        List<List<List<Integer>>> dp=new ArrayList<>();
        for(i=1;i<=t;i++) 
        { 
            List<List<Integer>> tem=new ArrayList<>(); 
            for(j=0;j<c.length && c[j]<=i;j++) 
            {
                if(i==c[j]) tem.add(Arrays.asList(c[j]));
                else 
                for(List<Integer> l : dp.get(i-c[j]-1)) 
                if(c[j]<=l.get(0)) 
                {
                    List cl=new ArrayList<>();
                    cl.add(c[j]); 
                    cl.addAll(l);
                    tem.add(cl);
                }
            }
            dp.add(tem);
        }
        return dp.get(t-1);

    }
}
