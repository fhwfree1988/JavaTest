package Sample.String;

public class StingNull {
    /*
    "first" property at method scope is CompileTime Error if it's not initialized.
    But if we define "first" property at global scope, it's OK
    */

    //static String first,second = "Me";
    public void Method(){
        String first,second = "Me";
        first = /*first +*/ second;//first is CompileTime Error
        //System.out.println(first);
    }
    public static void main(String[] args) {
        String first,second = "Me";
        first = /*first +*/ second;//first is CompileTime Error
        //System.out.println(first);
    }
}
