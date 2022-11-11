class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        long suma=0,sumb=0;
        int i,n=nums.length;
        ArrayList<Integer> oa=new ArrayList<>(),ob=new ArrayList<>(),ea=new ArrayList<>(),eb=new ArrayList<>();
        for(i=0;i<n;i++)
        {
            suma+=nums[i];
            sumb+=target[i];
            if(nums[i]%2==0) ea.add(nums[i]);
            else oa.add(nums[i]);
            
            if(target[i]%2==0) eb.add(target[i]);
            else ob.add(target[i]);
        }
        if(ea.size()!=eb.size() || oa.size()!=ob.size() || suma!=sumb) return -1; //never executed
        
        Collections.sort(ea); Collections.sort(oa);
        Collections.sort(eb); Collections.sort(ob);
        long ans=0;
        for(i=0;i<oa.size();i++) ans+=Math.abs(oa.get(i)-ob.get(i));
        for(i=0;i<ea.size();i++) ans+=Math.abs(eb.get(i)-ea.get(i));
        return ans/4;
    }
}
