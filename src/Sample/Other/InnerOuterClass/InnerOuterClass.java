package Sample.Other.InnerOuterClass;

class OuterClass {
    private int x = 10;

    class InnerClass {
        public int myInnerMethod() {
            return x;
        }
    }
}

public class InnerOuterClass {
    public static void main(String[] args) {
        /*
        Access Outer Class From Inner Class
        One advantage of inner classes, is that they can access attributes and methods of the outer class:
         */
        OuterClass myOuter = new OuterClass();
        OuterClass.InnerClass myInner = myOuter.new InnerClass();
        System.out.println(myInner.myInnerMethod());
    }
}