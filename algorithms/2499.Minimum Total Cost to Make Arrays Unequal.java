//Tamonash Chakraborty
//O(nlogn)
class Solution {
    public long minimumTotalCost(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=nums1.length,i;
        for(i=0;i<n;i++)
        if(nums1[i]==nums2[i])  //same group values cannot be swapped
        hm.put(nums1[i],hm.getOrDefault(nums1[i],0)+1);
        
        ArrayList<Integer> groups=new ArrayList<>();
        for(int x:hm.keySet()) groups.add(hm.get(x));
        Collections.sort(groups);
        int sz=groups.size(),tot=0;
        for(i=0;i+1<sz;i++) tot+=groups.get(i);
        if(sz==0) return 0;	//no swaps needed at all
        
        if(tot>=groups.get(sz-1))    //all bad indices can be swapped
        {
            tot+=groups.get(sz-1);
            int pairs=tot/2;    //each swap places 2 values in the right place
            
            long ans=0;
            for(i=0;i<n;i++)
            if(nums1[i]==nums2[i]) ans+=i;  //all bad indices will be swapped once
            
            if(tot%2==1) //there is 1 extra element which cannot be swapped
            {
                ans+=0;
                /*
                    why is this happening?
                    note that we reach here when => there are odd bad indices & hm has >2 keys
                    case 1: 
                        nums1[0]==nums2[0]
                        => 2 more indices j & k where nums1[j]==nums2[j] & nums1[k]==nums2[k]
                        and nums1[i]!=nums1[j]!=nums1[k]
                        => swap 0 with j and the 0 with k
                    case 2:
                        nums1[0]!=nums2[0]
                        => there has to exist 1 value in hm != nums1[0] and nums2[0]
                        => swap 0 with that value
                */
            }
            return ans;
        }    
        
        
        //other part now
        int max=groups.get(sz-1);
        for(int x:hm.keySet())
        if(hm.get(x)==max) {max=x; break;} 
        
        //tot is the number of pairs, other values are grouped with good values
        int rem=groups.get(sz-1)-tot;   //these values where nums1[i]==nums2[i]==max need outside help, because all others nums1[i]==nums2[i] have been fixed
        long ans=0;
        for(i=0;i<n;i++)
        if(nums1[i]==nums2[i]) ans+=i;
        else if(nums1[i]!=max && nums2[i]!=max && rem>0) 
        {
            ans+=i; rem--;  
            //this can be used to swap one of rem max values
            //also each such value can be used exactly once
        }   
        
        if(rem>0) ans=-1;
        return ans;
    }
}
