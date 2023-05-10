package Sample.Other.TryWithResources;

public class TryWithResources {

    //https://www.baeldung.com/java-try-with-resources
    public static void main(String[] args) throws Exception {
        TryWithResources tryWithResources = new TryWithResources();
        tryWithResources.orderOfClosingResources();
    }
    public void orderOfClosingResources() throws Exception {
        //---BEFORE JAVA 9
        /*try (AutoCloseableResourcesFirst af = new AutoCloseableResourcesFirst();
             AutoCloseableResourcesSecond as = new AutoCloseableResourcesSecond())*/

        //----JAVA 9
        AutoCloseableResourcesFirst af = new AutoCloseableResourcesFirst();
        AutoCloseableResourcesSecond as = new AutoCloseableResourcesSecond();
       /* try (af;as){
            af.doSomething();
            as.doSomething();
        }*/
    }

    class AutoCloseableResourcesFirst implements AutoCloseable {

        public AutoCloseableResourcesFirst() {
            System.out.println("Constructor -> AutoCloseableResources_First");
        }

        public void doSomething() {
            System.out.println("Something -> AutoCloseableResources_First");
        }

        @Override
        public void close() throws Exception {
            System.out.println("Closed AutoCloseableResources_First");
        }
    }

    class AutoCloseableResourcesSecond implements AutoCloseable {

        public AutoCloseableResourcesSecond() {
            System.out.println("Constructor -> AutoCloseableResources_Second");
        }

        public void doSomething() {
            System.out.println("Something -> AutoCloseableResources_Second");
        }

        @Override
        public void close() throws Exception {
            System.out.println("Closed AutoCloseableResources_Second");
        }
    }
}
