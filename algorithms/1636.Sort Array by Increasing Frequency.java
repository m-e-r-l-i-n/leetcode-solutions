class Solution {
    public int[] frequencySort(int[] nums) {
        int n=nums.length,i,c[][]=new int[201][2],ans[]=new int[n];
        for(i=0;i<=200;i++)
        c[i][1]=i-100;    
        for(i=0;i<n;i++)
        c[nums[i]+100][0]++;
        Arrays.sort(c,new Comparator<int[]>(){
            public int compare(int o1[],int o2[])
            {
                if(o1[0]>o2[0]) return 1;
                else if(o1[0]==o2[0]) return o1[1]<o2[1]?1:-1;
                else return -1;
            }
        });
        
        int j=0;
        for(i=0;i<=200;i++)
        {
            while(c[i][0]!=0)
            {
                ans[j++]=c[i][1];
                c[i][0]--;
            }
        }    
        return ans;
    }
}
