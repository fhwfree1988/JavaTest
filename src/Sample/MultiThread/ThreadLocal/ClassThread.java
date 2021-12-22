package Sample.MultiThread.ThreadLocal;

public class ClassThread implements Runnable {

	private static volatile Integer t = 1;

	private static ThreadLocal<String> threadLocal2 = new ThreadLocal<String>() {
		protected String initialValue() {
			return "Test" + t++;
		};
	};

	private String test;

	public ClassThread(String test) {
		this.test = test;
	}

	@Override
	public void run() {
		try {
			threadLocal2.get();
			Thread.sleep(40000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
