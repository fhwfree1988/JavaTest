public class main {
    public static void main(String[] args) {
        try {
            //myMethod();
            //a(5);



        }catch (Exception err){
            err.printStackTrace();
        }

    }
    static void a(int a , int...b){
        System.out.print(a);
    }

    static void a(int...b){
        System.out.print(b);
    }
    /*public static void myMethod() throws Exception{
        try {
            throw new Exception("E1");
        }catch (Exception err){
            throw new Exception("E2");
        }finally {
            //throw new Exception("E3");
            System.out.print("E3");
        }


    }*/

}
