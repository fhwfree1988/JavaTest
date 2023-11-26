package Sample.Other;


import java.io.Console;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Casting {
    static record Human (String name, int age, String profession) {}
    public static void main(String[] args) {

        Casting c = new Casting();
        double res = c.getResult(300,19,1.0216);
        //double res1 = c.getResult(300,20,1.0216);
        double res2 = c.getResultWP(300,19);
        double T = 2;
        int jar = (int) T;
        int min = Integer.MAX_VALUE;

        BigDecimal number = BigDecimal.valueOf(12.1234);
        String numberStr = number.toString();
        //integerDigits(number);

        String query = "select generate_request_no_pch({0},{1}) as No from dual";
        String type = "'5'";
        String plakNum = "'56465465'";
        query = MessageFormat.format(query, type,plakNum);
        if(checkValueAfterDigit(number))
            throw new RuntimeException();

        System.out.println("-----TIME END------  " + new SimpleDateFormat("mm:ss.SSS").format(new Date()));

        long systemMili = System.currentTimeMillis();
        System.out.println("before doing ------>>");
        //do somthing with deley
        System.out.println(getMilisString("after doing",systemMili));
    }

    public static String getMilisString(String title, long systemMili){
        StringBuilder s = new StringBuilder();
        s.append(title);
        s.append(" : ");
        s.append((System.currentTimeMillis() - systemMili));
        return s.toString();
    }

    public String checkObject(Object obj) {
        /*return switch (obj) {
            case Human h -> "Name: %s, age: %n and profession: %s".formatted(h.name(), h.age(), h.profession());
            case Circle c -> "This is a circle";
            default -> "It is an object";
        };*/
        return "";
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

            if(count == 1)
                all = all + 50;

            if(count == 6)
                all = all + 40;

            if(count > 6)
                all = all + (pp*1.20);
            else
                all = all + pp;

            if(count == 9) {
                all = all - 320;
                System.out.println("count == 9 --> " + all);
                if(all < 0)
                    all = 0;
            }
            if(count == 12)
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
            if(count == 1)
                all = all + 50;
            if(count ==6)
                all = all + 40;

            if(count > 6)
                all = all + (pp*1.20);
            else
                all = all + pp;

            if(count == 9) {
                all = all - 320;
                System.out.println("count == 9 --> " + all);
                if(all < 0)
                    all = 0;
            }

            if(count == 12)
                all = all + 30;

            count++;
        }

        return all;
    }

}
