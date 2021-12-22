package ir.Me.session_3.e16;

public class InterfaceTester implements MyInterface {
    public static void main(String[] args) {
        MyInterface myInterface = new InterfaceTester();
        myInterface.showMessage();

        MyInterface.showX();
    }
}
