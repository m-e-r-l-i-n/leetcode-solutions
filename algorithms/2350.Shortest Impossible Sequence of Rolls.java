//Tamonash Chakraborty
//O(n)
class Solution {
    public int shortestSequence(int[] rolls, int k) {
        Set<Integer> use=new HashSet<>();
        int ans=1;
        for(int x:rolls)
        {
            use.add(x);
            if(use.size()==k) {ans++; use.clear();}
        }
        return ans;
    }
}
