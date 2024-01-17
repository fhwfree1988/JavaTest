package Sample.MultiThread.VirtualThreads;
import java.util.concurrent.ThreadFactory;

//https://www.baeldung.com/java-virtual-thread-vs-thread
//https://medium.com/@RamLakshmanan/java-virtual-threads-easy-introduction-44d96b8270f8
public class VirtualThreads {
    public static void main(String[] args) {
        Runnable printThread = () -> System.out.println(Thread.currentThread());

        ThreadFactory virtualThreadFactory = Thread.ofVirtual().factory();
        ThreadFactory kernelThreadFactory = Thread.ofVirtual().factory();

        Thread virtualThread = virtualThreadFactory.newThread(printThread);
        Thread kernelThread = kernelThreadFactory.newThread(printThread);

        virtualThread.start();
        kernelThread.start();

        /*Thread virtualThread = Thread.ofVirtual().start(() -> {
            // Code to be executed by the virtual thread
        });

        virtualThread.start();*/

       /* Runnable task = () -> { System.out.println("Hello Virtual Thread!"); };
        Thread.startVirtualThread(task);*/
    }
    public String test(Object obj) {

        return switch(obj) {

            case Integer i -> "An integer";

            case String s -> "A string";

            //case Cat c -> "A Cat";

            default -> "I don't know what it is";

        };

    }
}
