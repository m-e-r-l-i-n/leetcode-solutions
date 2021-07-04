class Solution {
    public List<Integer> findClosestElements(int[] a, int k, int x) {
        Deque<Integer> ans=new LinkedList<>();
        int i,n=a.length,l,r;
        for(i=0;i<n;i++)
        if(a[i]>=x) break;
        l=i-1; r=i;
    
        while(ans.size()<k)
        {
            if(l>=0 && r<n)
            {
                if(x-a[l]<=a[r]-x) ans.addFirst(a[l--]);
                else ans.addLast(a[r++]);
            }
            else if(l>=0) ans.addFirst(a[l--]);
            else ans.addLast(a[r++]);
        }
        
        List<Integer> li=new ArrayList<>();
        while(!ans.isEmpty()) li.add(ans.removeFirst());
        return li;
    }
}
