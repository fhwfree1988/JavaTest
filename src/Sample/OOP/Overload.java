package Sample.OOP;

class car{
    public void accelerate(){
        System.out.println("car : accelerate ");
    }
}

class Lambo extends car{
    public void accelerate(int speedLimite){
        System.out.println("car : accelerate(int speedLimite) ");
    }
    public void accelerate(){
        System.out.println("Lambo : accelerate ");
    }
}

public class Overload {


    public static void main(String[] args) {
        car c1 = new Lambo();
        car c2 = new car();
        Lambo c3 = new Lambo();

        c1.accelerate();
        c2.accelerate();
        c3.accelerate();
        c3.accelerate(1);
    }

}
