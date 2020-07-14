class Solution {
    public double angleClock(int h, int m) {
        if(h==12) h=0; 
        double ha=(0.5*(60.0*h+m)),ma=6.0*m;   
        double ang=Math.abs(ha-ma);
        ang=Math.min(360-ang,ang); 
        return ang; 
    }
}
