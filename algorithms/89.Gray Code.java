class Solution {
    public List<Integer> grayCode(int n) {
        int m=1<<n,i;
        List<Integer> ans=new ArrayList<>();
        for(i=0;i<m;i++) ans.add(i^(i>>1));
        return ans;
    }
}
