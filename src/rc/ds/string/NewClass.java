package ds.string;

public class NewClass extends Thread {
	
	public void runone()
	{
		synchronized (this) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
