class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int days[]={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int ta[]={which_day(days,arriveAlice),which_day(days,leaveAlice)};
        int tb[]={which_day(days,arriveBob),which_day(days,leaveBob)};
        int i,ans=0;
        for(i=0;i<=366;i++)
        if(i>=ta[0] && i<=ta[1] && i>=tb[0] && i<=tb[1]) ans++;
        return ans;
    }
    
    int which_day(int days[],String date)
    {
        String s[]=date.split("-");
        int month=Integer.parseInt(s[0])-1,day=Integer.parseInt(s[1]);
        int i,ans=0;
        for(i=0;i<=month;i++)
        if(i<month) ans+=days[i];
        else ans+=day;
        return ans;
    }
}
