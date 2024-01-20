package Sample.JavaFeatures.F8;

public class Lambdas {
    public static void main(String[] args) {
        Runnable runnable = new Runnable(){
            @Override
            public void run(){
                System.out.println("Hello world !");
            }
        };

        //With lambdas, the same code looks like this:
        Runnable runnableWithLambdas = () -> System.out.println("Hello world two!");
    }
}
