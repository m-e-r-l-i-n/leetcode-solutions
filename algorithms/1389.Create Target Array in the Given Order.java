class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int i,n=nums.length;
        ArrayList<Integer> tar=new ArrayList();
        for(i=0;i<n;i++)
        tar.add(index[i],nums[i]);
        int fin[]=new int[n];
        for(i=0;i<n;i++)
        fin[i]=tar.get(i);
        return fin;
    }
}
