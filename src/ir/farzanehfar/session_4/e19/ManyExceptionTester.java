package ir.farzanehfar.session_4.e19;

import java.io.IOException;

public class ManyExceptionTester {
    public static void main(String[] args) {
        try {
            test2();
        } catch (ExampleException e) {
            System.err.println(e.message);
        }

    }

    public static void test2() {
        test();
        System.out.println("sssss");
    }

    public void mainF() throws IOException, IllegalArgumentException, ClassNotFoundException, NoSuchFieldException {
        f1();
        f2();
        f3();
        f4();
    }

    public static void test() throws ExampleException {
        try {
            throw new Exception("Error!!!!");
        } catch (Exception e) {
            //e.printStackTrace();
            throw new ExampleException(e,"خطا رخ داد");
        }
    }

    public void f1() throws IOException {

    }

    public void f2() throws ClassNotFoundException {

    }

    public void f3() throws NumberFormatException {

    }

    public void f4() throws NoSuchFieldException {

    }
}

class ExampleException extends RuntimeException {
    Exception ex;
    String message;

    public ExampleException(Exception ex, String message) {
        this.ex = ex;
        this.message = message;
    }
}