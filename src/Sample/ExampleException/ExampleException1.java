package Sample.ExampleException;

public class ExampleException1 {
    public static void main(String[] args) {
        ExampleException1 exampleException1 = new ExampleException1();
        exampleException1.Method2();
    }

    private void Method1() throws /*Exception*/RuntimeException{
        //throw new RuntimeException("Me ExampleException");

    }
    public void Method2(){
        Method1();
        Method3();
    }
    public void Method3(){
        System.out.println("ME 3");

    }
}
