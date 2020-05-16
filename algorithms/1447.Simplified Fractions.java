class Solution {
    public List<String> simplifiedFractions(int n) {
        ArrayList<String> s=new ArrayList<>();
        ArrayList<Double> v=new ArrayList<>();
        int i,j;
        for(i=1;i<n;i++)
        for(j=i+1;j<=n;j++)
        {
            double x=1.0*i/j;
            if(v.contains(x)==false)
            {
                v.add(x);
                String st=Integer.toString(i)+"/"+Integer.toString(j);
                s.add(st);
            }
        }
        return s;
    }
}
