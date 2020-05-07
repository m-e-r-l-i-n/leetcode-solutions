import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] a) {
        Arrays.sort(a);
        int i, n=a.length;
        List<List<Integer>> li=new ArrayList<List<Integer>>();
        for(i=0;i<n-2;i++)
        {
            if(i!=0 && a[i]==a[i-1]) continue;
            int l=i+1,r=n-1,x=a[i];
            while(l<r)
            {
                int temp=x+a[l]+a[r];
                if(temp==0)
                {
                    ArrayList<Integer> nl=new ArrayList<>();
                    nl.add(x);nl.add(a[l]);nl.add(a[r]); 
                    li.add(nl);
                    while(l<r && a[r]==a[r-1])r--;
                    while(l<r && a[l]==a[l+1])l++;
                    r--; l++;
                }
                else if(temp>0) r--;
                else l++;                
            }
        }
        return li;        
    }
}
