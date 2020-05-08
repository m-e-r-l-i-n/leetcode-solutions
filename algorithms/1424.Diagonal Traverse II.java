class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int i=0,j=0,max=0;
        HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();
        for(i=0;i<nums.size();i++)
        for(j=0;j<nums.get(i).size();j++)
        {
            if(hm.get(i+j)==null)
            {
                ArrayList<Integer> al=new ArrayList<>();
                al.add(nums.get(i).get(j));
                hm.put(i+j,al);
            }
            else hm.get(i+j).add(0,nums.get(i).get(j));
            max++;
        }
        int a[]=new int[max]; i=0;
        ArrayList<Integer> k=new ArrayList<>();
        
        for(int x:hm.keySet()) k.add(x);
        Collections.sort(k);
        
        for(int x=0;x<k.size();x++)
        for(j=0;j<hm.get(k.get(x)).size();j++)
        a[i++]=hm.get(k.get(x)).get(j);
        return a;
    }
}
