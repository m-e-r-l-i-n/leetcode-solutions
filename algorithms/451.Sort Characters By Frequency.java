class Solution {
    public String frequencySort(String s) 
    {
        int c[][]=new int[256][2],i,j;
        for(i=0;i<256;i++)
        c[i][1]=i;
        
        for(i=0;i<s.length();i++)
        c[s.charAt(i)][0]++;
        
        Arrays.sort(c,new Comparator<int[]>(){
            public int compare(int e1[],int e2[])
            {
                if(e1[0]>e2[0]) return 1;
                else return -1;
            }});
        StringBuilder sb=new StringBuilder();
        for(i=255;i>=0;i--)
        {
            for(j=0;j<c[i][0];j++)
                sb.append((char)c[i][1]);
        }
        return sb.toString();
        
    }
}
