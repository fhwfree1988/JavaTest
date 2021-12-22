package Sample.TrickyInterviewQuestions.Question1Overloading;

public class Question {
    public static void main(String[] args) {
        foo(null);
    }
    public static void foo(Object o) {
        System.out.println("Object impl");
    }
    public static void foo(String s) {
        System.out.println("String impl");
    }
    /*
    public static void foo(StringBuffer i){
		System.out.println("StringBuffer impl");
	}
     */
}
