//Tamonash Chakraborty
//O(nlogn)
class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        TreeMap<Integer,Integer> hm=new TreeMap<>();
        for(int x[]:items1) hm.put(x[0],x[1]);
        for(int x[]:items2) hm.put(x[0],hm.getOrDefault(x[0],0)+x[1]);
        
        int n=0;
        ArrayList<List<Integer>> ans = new ArrayList<>();
        for(int x:hm.keySet()) 
        {
            List<Integer> res=new ArrayList<>();
            res.add(x); res.add(hm.get(x));
            ans.add(res);
        }
        return ans;
    }
}
