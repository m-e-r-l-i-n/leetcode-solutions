//Tamonash Chakraborty
//O(n)
class Solution {
    public int minimumOperations(int[] nums) {
        //if(nums.length==1) return 0;
        HashMap<Integer,Integer> hm[]=new HashMap[2];
        int i,c[]=new int[2];   //c for count of odd and even indices
        for(i=0;i<2;i++) 
        {
            hm[i]=new HashMap<>(); //used to count number of values in odd indices and even indices
            hm[i].put(0,0);
        }
        
        for(i=0;i<nums.length;i++)
        {
            hm[i%2].put(nums[i],hm[i%2].getOrDefault(nums[i],0)+1);
            c[i%2]++;
        }
        
        int max[][]=new int[2][2];
        for(i=0;i<2;i++)
        for(int x:hm[i].keySet())
        {
            int v=hm[i].get(x); //find maximum and second maximum count
            if(v>hm[i].get(max[i][0]))
            {
                max[i][1]=max[i][0];
                max[i][0]=x;
            }
            else if(v>hm[i].get(max[i][1])) max[i][1]=x;
        }
        
        int j,ans=Integer.MAX_VALUE;
        for(i=0;i<2;i++)
        for(j=0;j<2;j++)
        if(max[0][i]!=max[1][j]) ans=Math.min(ans,c[0]-hm[0].get(max[0][i])+c[1]-hm[1].get(max[1][j])); //minimum changes
        return ans;
    }
}
