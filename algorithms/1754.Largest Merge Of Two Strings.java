class Solution {
    public String largestMerge(String word1, String word2) {
        ArrayList<String> w=new ArrayList<>();
        StringBuilder ans=new StringBuilder();
        StringBuilder a=new StringBuilder(),b=new StringBuilder();
        char g[]=new char[123];
        
        for(int i=97,j='z';i<=122;i++,j--)
        g[i]=(char)j;
        for(int i=0;i<word1.length();i++)
        a.append(g[word1.charAt(i)]);
        for(int i=0;i<word2.length();i++)
        b.append(g[word2.charAt(i)]);
        
        w.add(a.toString()); w.add(b.toString());
        while(w.size()>0)
        {
            Collections.sort(w,new Comparator<String>(){
                public int compare(String o1, String o2) 
                {
                    for(int i=0;i<o1.length() && i<o2.length();i++)
                    if(o1.charAt(i)!=o2.charAt(i))return o1.charAt(i)-o2.charAt(i);
                    
                    if(o1.length()>o2.length())return -1;
                    if(o1.length()<o2.length())return 1;
                    return 0;
                }});
            ans.append(g[w.get(0).charAt(0)]);
            if(w.get(0).length()>1)
            {
                String s=w.get(0).substring(1);
                w.set(0,s);
            }
            else w.remove(0);
        }
        return ans.toString();
    }
}
