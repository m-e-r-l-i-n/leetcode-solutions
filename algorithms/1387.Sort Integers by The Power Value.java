class Solution {
    public int getKth(int lo, int hi, int k) {
        int i, power[][]=new int[hi-lo+1][2];
        for(i=lo;i<=hi;i++)
        {
            int x=i,pow=0;
            while(x!=1)
            {
                if(x%2==0) x=x/2;
                else x=3*x+1;
                pow++;
            }
            power[i-lo][0]=i; power[i-lo][1]=pow;
        }
        
        Arrays.sort(power, new Comparator<int []>()
        {
            public int compare(final int entry1[],final int entry2[])
            {
                if(entry1[1]>entry2[1]) return 1;
                else if(entry1[1]==entry2[1] && entry1[0]>entry2[0]) return 1;
                else return -1;
            }
        });
        
        return power[(k-1)][0];
    }
}
