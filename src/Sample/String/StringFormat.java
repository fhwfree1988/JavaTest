package Sample.String;

import java.nio.charset.StandardCharsets;
import java.text.Bidi;

public class StringFormat {

    public static void main(String[] args) {

        String city = "تهران";
        //String city = "%u062A%u0647%u0631%u0627%u0646";
        String serial = "11";
        String leftDigits = "17";
        String character = "ب";
        //String character = "%u0628";
        String rightDigits = "587";

        String  PLT= "\u200F " + city + "-" + serial + "/" + leftDigits + character + rightDigits;
        //PLT = StringFormat.align(PLT,PLT.length(),true);
        String PLT_Format = new String(PLT.getBytes(), StandardCharsets.UTF_8);

        //Bidi b = new Bidi(PLT.toCharArray(),0, null, 0, PLT.length(), 0);
        //Bidi b = new Bidi(PLT_Format,1);
        //Bidi.requiresBidi(PLT.toCharArray(),0,PLT.length());

        System.out.println(PLT_Format);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(city);
        stringBuilder.append("-");
        stringBuilder.append(serial);
        stringBuilder.append("/");
        stringBuilder.append(leftDigits);
        stringBuilder.append(character);
        stringBuilder.append(rightDigits);

        System.out.println(stringBuilder.toString());

    }
    static String align(String str, int width, boolean right){
        String[] temp = str.split("\n");
        String frmt = "";
        if(right){
            frmt = "%" + width + "s";
        }
        else{
            frmt = "%-" + width + "s";
        }

        for(int i=0; i<temp.length; i++)
            temp[i] = String.format(frmt, temp[i]);
        return String.join("\n", temp);
    }
}
