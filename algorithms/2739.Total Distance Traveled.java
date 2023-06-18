class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int distance=0;
        while(mainTank>4)
        {
            distance+=50;
            mainTank-=5;
            if(additionalTank>0)
            {
                additionalTank--;
                mainTank++;
            }
        }
        return distance+mainTank*10;
    }
}
