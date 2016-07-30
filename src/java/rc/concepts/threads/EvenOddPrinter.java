package rc.concepts.threads;

import rc.concepts.threads.util.Message;

public class EvenOddPrinter {

	public static void main(String[] args) {
		Message lockObject = Message.getInstance();
		Message.setMsg("Even");

		new Thread(new OddPrinter(lockObject)).start();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(new EvenPrinter(lockObject)).start();

	}
}

class EvenPrinter implements Runnable {

	private Message message;

	EvenPrinter(Message message) {
		this.message = message;
	}

	@Override
	public void run() {
		int i = 0;
		while (i < 10) {
			synchronized (message) {
				if (message.getMsg().equals("Even")) {
					System.out.println(i);
					message.setMsg("Odd");
					message.notify();
					i += 2;

					try {
						message.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}
	}

}

class OddPrinter implements Runnable {
	private Message message;

	OddPrinter(Message message) {
		this.message = message;
	}

	@Override
	public void run() {
		int i = 1;
		while (i < 10) {
			synchronized (message) {

				if (message.getMsg().equals("Odd")) {
					System.out.println(i);
					message.setMsg("Even");
					message.notify();
					i += 2;

					try {
						message.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}

		}
	}
}
