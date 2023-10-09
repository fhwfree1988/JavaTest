package Sample.Other;

import java.io.Console;
import java.math.BigDecimal;

public class Casting {
    public static void main(String[] args) {

        Casting c = new Casting();
        double res = c.getResult(60,15,1.0216);
        //double res1 = c.getResult(30,16,1.0216);
        double res2 = c.getResultWP(270,15);
        double T = 2;
        int jar = (int) T;
        int min = Integer.MAX_VALUE;

        BigDecimal number = BigDecimal.valueOf(12.1234);
        String numberStr = number.toString();
        //integerDigits(number);

        if(checkValueAfterDigit(number))
            throw new RuntimeException();
    }

    static int integerDigits(BigDecimal n) {
        n = n.stripTrailingZeros();
        return n.precision() - n.scale();
    }

    static boolean checkValueAfterDigit(BigDecimal number) {
        number = number.stripTrailingZeros();
        return number.scale() > 3;
    }

    public double getResult(int firstStep,int plus,double percent){
        int count = 1;
        double all = firstStep;
        double pp = plus;

        while(count < 13){
            pp = plus;
            if(count > 1)
                all = all * percent;

            if(count == 1)
                all = all + 24;
            if(count == 5)
                all = all + 5 ;//-100;
            if(count == 6)
                all = all + 40;

            if(count >1)
                pp = (pp*1.25);
            if(count > 7)
                all = all + (pp*1.20);
            else
                all = all + pp;

            if(count == 10) {
                //all = all * 1.3;
                all = all - 320;
                System.out.println("count == 10 --> " + all);
                if(all < 0)
                    all = 0;
            }
            /*if(count == 10) {
                all = all + 100;
            }*/
            /*if(count == 11) {
                all = all + 100;
            }*/
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

        while(count < 13){
            pp = plus;
            if(count == 1)
                all = all + 24;
            if(count == 5)
                all = all + 15;
            if(count == 6)
                all = all + 40;
            if(count >1)
                pp = (pp*1.25);

            if(count > 7)
                all = all + (pp*1.20);
            else
                all = all + pp;

            if(count == 10) {
                all = all - 320;
                System.out.println("count == 10 --> " + all);
                if(all < 0)
                    all = 0;
            }
           /* if(count == 10) {
                all = all + 100;
            }*/

            if(count == 13)
                all = all + 30;

            count++;
        }

        return all;
    }

}
