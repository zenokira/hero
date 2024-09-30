package src;

public class SynchronizedCounter {

	private int c = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object sharedObj = new Object();
		PrintThread t1 = new PrintThread("스레드 A",sharedObj);
		PrintThread t2 = new PrintThread("스레드 B",sharedObj);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		}catch(Exception e)
		{
			System.out.println("인터럽트 걸림");
		}
		
	}
}


class PrintThread extends Thread
{
	private String threadName;
	private Object sharedObject;
	
	PrintThread (String name, Object shared)
	{
		threadName = name;
		sharedObject = shared;
	}
	
	public void run()
	{
		synchronized (sharedObject) {
		printCount();
		}
		System.out.println("스레드 " + threadName + " 종료 ");
	}
	
	public void printCount()
	{
		try {
			for(int i = 10; i > 0; i--)
			{
				System.out.println(threadName + " : Counter --- " + i);
			}
		}catch(Exception e)
		{
			System.out.println(threadName + " : 스레드 인터럽트 됨");
		}
	}
}