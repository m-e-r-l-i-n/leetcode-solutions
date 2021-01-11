class Solution {
    public int ladderLength(String be, String en, List<String> w) {
        if(!w.contains(en)) return 0;
        Set<String> b=new HashSet<String>(),e=new HashSet<String>();
        int ans=1,l=be.length(),i;
        HashSet<String> v=new HashSet<String>();

        b.add(be);
        e.add(en);
        while(!b.isEmpty() && !e.isEmpty())
        {
            if(b.size()>e.size())
            {
                Set<String> set=b;
                b=e;
                e=set;
            }

            Set<String> temp=new HashSet<String>();
            for(String word : b)
            {
                char[] chs=word.toCharArray();
                for(i=0; i<chs.length; i++)
                for(char c='a'; c<='z'; c++)
                {
                    char old=chs[i];
                    chs[i]=c;
                    String target=String.valueOf(chs);
                    
                    if(e.contains(target)) return ans+1;
                    if(!v.contains(target) && w.contains(target))
                    {
                        temp.add(target);
                        v.add(target);
                    }
                    chs[i]=old;
                }
            }
            b=temp;
            ans++;
        }
        return 0;
    }
}
