//Tamonash Chakraborty
//O(nlogn)
class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        ArrayList<Integer> start=new ArrayList<>(),end=new ArrayList<>();
        for(int x[]:flowers)
        {
            start.add(x[0]);    //add start time
            end.add(x[1]);  //add end time
        }
        
        Collections.sort(start); Collections.sort(end);
        int n=persons.length,ans[]=new int[n],i;
        for(i=0;i<n;i++)
        ans[i]=lower(start,persons[i])-lower(end,persons[i]-1); 
        //count ranges beginning before persons[i] but ending >=persons[i]
        return ans;
    }
    
    int lower(ArrayList<Integer> a,int key) //binary search to count elements <=key
    {
        int l=0,r=a.size()-1,mid,ans=0;
        while(l<=r)
        {
            mid=(l+r)>>1;
            if(a.get(mid)<=key)
            {
                ans=mid+1;
                l=mid+1;
            }
            else r=mid-1;
        }
        return ans;
    }
}
