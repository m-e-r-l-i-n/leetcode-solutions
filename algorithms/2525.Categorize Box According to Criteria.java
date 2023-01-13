class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        long volume=1l*length*width*height,mx=(int)1e4;
        
        boolean bulky=length>=mx || width>=mx || height>=mx || volume>=mx*mx*10;
        boolean heavy=mass>=100;
        String ans="Neither";
        if(bulky & heavy) ans="Both";
        else if(bulky) ans="Bulky";
        else if(heavy) ans="Heavy";
        return ans;
    }
}
