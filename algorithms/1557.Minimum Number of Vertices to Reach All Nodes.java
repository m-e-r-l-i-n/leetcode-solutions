class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int i,c[]=new int[n];
        for(List l:edges)
            c[(int)l.get(1)]++;
        
        List<Integer> ans=new ArrayList<>();
        for(i=0;i<n;i++)
        if(c[i]==0) ans.add(i);    
        return ans;
    }   
}
