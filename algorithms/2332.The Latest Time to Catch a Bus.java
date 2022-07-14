class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        
        int i=0,j=0,n=buses.length,m=passengers.length,ans=1;
        while(i<n)
        {
            int use=0;
            while(j<m && use<capacity && passengers[j]<=buses[i])
            {
                if(j==0 || (j>0 && passengers[j]-passengers[j-1]>1)) ans=passengers[j]-1;
                j++; use++;
            }
            if(use<capacity && (j==0 || (j>0 && passengers[j-1]<buses[i]))) ans=buses[i];
            i++;   
        }
        return ans;
    }
}
