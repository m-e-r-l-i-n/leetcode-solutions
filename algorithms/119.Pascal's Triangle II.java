class Solution {
    public List<Integer> getRow(int rowIndex) {
        long coeff=1,i;
        List<Integer> l=new ArrayList<>();
        l.add(1);
        for(i=1;i<=rowIndex;i++)
        {
            coeff=coeff*(rowIndex-i+1)/i;
            coeff=coeff%10000000007l;
            l.add((int)coeff);
        }
        return l;
    }
}
