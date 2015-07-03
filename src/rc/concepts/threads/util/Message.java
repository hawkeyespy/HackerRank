package rc.concepts.threads.util;



public class Message {
	private static Message message = new Message();
	private static String msg;
	
	public static String getMsg() {
		return msg;
	}

	public static void setMsg(String msg) {
		Message.msg = msg;
	}

	private Message()
	{
		
	}
	
	public static Message getInstance()
	{
		return message;
	}
}
