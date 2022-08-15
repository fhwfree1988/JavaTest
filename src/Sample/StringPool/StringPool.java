package Sample.StringPool;

public class StringPool {
    public static void main(String[] args) {
        String s1 = "Cat";
        String s2 = "Cat";
        String s3 = new String("Cat");

        System.out.println("s1 == s2 :"+(s1==s2));
        System.out.println("s1 == s3 :"+(s1==s3));
        System.out.println("s1 equal s3 :"+(s1.equals(s3)));


        String str1 = "my-string";
        String str2 = new String("my-string");
        str2.intern();
        System.out.println("intern --> " + (str1 == str2));


        //-----------------------
        String ss1 = "abc";
        String ss2 = new String("abc");
        String ss3 = new String("foo");
        String ss4 = ss1.intern();
        String ss5 = ss2.intern();
        System.out.println("ss3 == ss4 : " + (ss3 == ss4));
        System.out.println("ss1 == ss5 : " + (ss1 == ss5));
    }
}
