class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        recur(ans,new ArrayList<Integer>(),k,n,1);
        return ans;
    }
    
    void recur(List<List<Integer>> ans,List<Integer> l,int k,int target,int start)
    {
        if (k==0 && target==0) ans.add(new ArrayList<Integer>(l));
        else 
        {
            for(int i=start; i<10 && target>0 && k>0;i++)
            {
                l.add(i);
                recur(ans,l,k-1,target-i,i+1);
                l.remove(l.size()-1);
            }
        }
    }

}
