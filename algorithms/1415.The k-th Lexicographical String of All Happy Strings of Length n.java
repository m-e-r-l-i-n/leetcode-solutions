class Solution {
    public String getHappyString(int n, int k) 
    {
        int i;
        ArrayList<String> a=new ArrayList<>();
        ArrayList<String> b=new ArrayList<>();
        ArrayList<String> c=new ArrayList<>();
        a.add("a");
        b.add("b");
        c.add("c");
        a=generate(a,n);
        b=generate(b,n);
        c=generate(c,n);
        if(k<=a.size())
            return a.get(k-1);
        else if(k<=(a.size()+b.size()))
        {
            k-=a.size();
            return b.get(k-1);
        }
        else if(k<=(a.size()+b.size()+c.size()))
        {
            k-=a.size()+b.size();
            return c.get(k-1);
        }
        else return "";
    }
    
    ArrayList<String> generate(ArrayList<String> s,int n)
    {
        if(s.get(0).length()==n) return s;
        ArrayList<String> s2=new ArrayList<>();
        for(int i=0;i<s.size();i++)
        {
            String st=s.get(i);
            char c=st.charAt(st.length()-1);
            if(c=='a') {s2.add(st+"b"); s2.add(st+"c");}
            else if(c=='b') {s2.add(st+"a"); s2.add(st+"c");}
            else {s2.add(st+"a");s2.add(st+"b");}
        }
        return generate(s2,n);
    }
}
