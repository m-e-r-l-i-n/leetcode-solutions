import java.time.*;
import java.time.temporal.*;
class Solution {
    public int daysBetweenDates(String date1, String date2) 
    {
        String s[]=date1.split("-");
        int d1[]=new int[3], d2[]=new int[3],i;
        for(i=0;i<3;i++)
        d1[i]=Integer.parseInt(s[i]);
        s=date2.split("-");
        for(i=0;i<3;i++)
        d2[i]=Integer.parseInt(s[i]);
        return Math.abs(count(d1)-count(d2));
    }
    
    int count(int d[])
    {
        int c=0,i, m[]={31,28,31,30,31,30,31,31,30,31,30,31};
        for(i=1971;i<d[0];i++)
        if((i%4==0 && i%100!=0) || (i%100==0 && i%400==0)) c+=366;
        else c+=365;
        
        for(i=1;i<d[1];i++)
        c+=m[i-1];
        
        if(d[1]>2 && ((d[0]%4==0 && d[0]%100!=0) || (d[0]%100==0 && d[0]%400==0)))
            c+=1;
        
        c+=d[2];
        return c;        
    }
}
