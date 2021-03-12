class Solution {
    public String intToRoman(int num) {
        String m[]={"","M","MM","MMM"};
        String c[]={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String x[]={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String i[]={"","I","II","III","IV","V","VI","VII","VIII","IX"};
        return m[num/1000]+c[(num%1000)/100]+x[(num%100)/10]+i[num%10];
    }
}
