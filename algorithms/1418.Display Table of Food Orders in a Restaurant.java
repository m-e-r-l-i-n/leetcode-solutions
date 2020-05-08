class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
     
        int i;
        List<List<String>> res=new ArrayList<>();
        ArrayList<String> head=new ArrayList<>();
        int tab[][]=new int[501][10000],maxt=0;
        for(i=0;i<orders.size();i++)
        {
            String item=orders.get(i).get(2); int t=Integer.parseInt(orders.get(i).get(1));
            if(!head.contains(item)) head.add(item);
            tab[t][0]=1;
            if(t>maxt) maxt=t;
        }
        Collections.sort(head);
        head.add(0,"Table");
        res.add(head);
        for(i=0;i<orders.size();i++)
        {
            String item=orders.get(i).get(2);
            int x=head.indexOf(item),t=Integer.parseInt(orders.get(i).get(1));
            tab[t][x]++;
        }
        
        for(i=1;i<=maxt;i++)
        {
            if(tab[i][0]==0) continue;
            ArrayList<String> temp=new ArrayList<>();
            temp.add(""+i);
            for(int j=1;j<head.size();j++)
                temp.add(""+tab[i][j]);
            res.add(temp);
        }
        return res;
        
    }
}
