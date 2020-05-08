class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String,Integer> left=new HashMap<>();
        HashMap<String,Integer> right=new HashMap<>();
        for(int i=0;i<paths.size();i++)
        {
            String l=paths.get(i).get(0),r=paths.get(i).get(1);
            if(left.get(l)==null) left.put(l,1);
            else left.put(l,left.get(l)+1);
            if(right.get(r)==null) right.put(r,1);
            else right.put(r,right.get(r)+1);
        }
        String ans="";
        for(String x:right.keySet())
            if(left.get(x)==null) {ans=x; break;}
        return ans;
    }
}
