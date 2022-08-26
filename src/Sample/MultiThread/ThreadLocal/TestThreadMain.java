package Sample.MultiThread.ThreadLocal;

public class TestThreadMain {
	//https://www.baeldung.com/java-threadlocal
	public static void main(String[] args) {
		ClassThread tt1 = new ClassThread("test1");
		ClassThread tt2 = new ClassThread("test2");
		Thread t1 = new Thread(tt1);
		Thread t2 = new Thread(tt2);

		t1.start();
		t2.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
