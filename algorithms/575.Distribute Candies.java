class Solution {
    public int distributeCandies(int[] c) {
        int n=c.length,k=n/2;
        Set<Integer> set=new HashSet<>();
        for(int i:c)
        if(k>0 && !set.contains(i))
        {
            set.add(i);
            k--;
        }
        return set.size();
    }
}
