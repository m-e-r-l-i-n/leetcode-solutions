class Solution {
    public String reorganizeString(String s) {
        int n=s.length(),c[][]=new int[26][2],i;
        for(i=0;i<26;i++) c[i][1]=i;
        for(i=0;i<n;i++) c[s.charAt(i)-'a'][0]++;
        
        for(i=0;i<26;i++)
        if(c[i][0]>(n+1)/2) return "";
        
        Arrays.sort(c,new Comparator<int[]>(){
            public int compare(int o1[],int o2[])
            {
                if(o1[0]>o2[0]) return -1;
                else if(o1[0]==o2[0]) return o1[1]>o2[1]?1:-1;
                else return 1;
            }});
        char ans[]=new char[n];
        int j=0;
        for(i=0;i<n;i+=2)
        {
            while(c[j][0]==0) j++;
            ans[i]=(char)(c[j][1]+'a');
            c[j][0]--;
        }   
        for(i=1;i<n;i+=2)
        {
            while(c[j][0]==0) j++;
            ans[i]=(char)(c[j][1]+'a');
            c[j][0]--;
        }
        return new String(ans);
    }
}
