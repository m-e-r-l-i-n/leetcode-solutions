class Solution {
    public String arrangeWords(String text) {
        String s[]=text.split(" ");
        int i,n[][]=new int[s.length][2];
        for(i=0;i<s.length;i++)
        {n[i][0]=s[i].length(); n[i][1]=i;}
        
        Arrays.sort(n,new Comparator<int[]>(){
            public int compare(int e1[],int e2[])
            {
                if(e1[0]>e2[0]) return 1;
                else if(e1[0]==e2[0])
                {
                    if(e1[1]>e2[1]) return 1;
                    else return -1;
                }
                else return -1;
            }});
        String ans=""+Character.toUpperCase(s[n[0][1]].charAt(0))+s[n[0][1]].substring(1)+" ";
        for(i=1;i<s.length;i++)
            ans+=s[n[i][1]].toLowerCase()+" ";
        return ans.trim();
    }
}
