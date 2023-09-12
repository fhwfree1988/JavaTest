package Sample.Other;

public class Casting {
    public static void main(String[] args) {

        Casting c = new Casting();
        double res = c.getResult(270,16,1.0216);
        double res2 = c.getResultWP(270,16);
        double T = 2;
        int jar = (int) T;
        int min = Integer.MAX_VALUE;
    }
    public double getResult(int firstStep,int plus,double percent){
        int count = 1;
        double all = firstStep;
        double pp = plus;

        while(count < 15){

            if(count > 1)
                all = all * percent;

            if(count == 1)
                all = all + 24;
            if(count == 5)
                all = all + 15;
            if(count == 7)
                all = all + 40;
            /*if(count >2)
                pp = (pp*1.05);*/
            if(count > 7)
                all = all + (pp*1.20);
            else
                all = all + pp;

            if(count == 9) {
                //all = all * 1.3;
                all = all - 320;
            }
            if(count == 13)
                all = all + 30;

            count++;
        }

        return all;
    }
    public double getResultWP(int firstStep,int plus){
        int count = 1;
        double all = firstStep;
        double pp = plus;

        while(count < 14){
            if(count == 1)
                all = all + 24;
            if(count == 5)
                all = all + 15;
            if(count == 7)
                all = all + 35;
            if(count >2)
                pp = (pp*1.05);
            if(count > 7)
                all = all + (pp*1.20);
            else
                all = all + pp;

            if(count == 13)
                all = all + 25;

            count++;
        }

        return all;
    }

}
