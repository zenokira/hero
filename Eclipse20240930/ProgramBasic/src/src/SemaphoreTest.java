package src;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int numOfThreads = 10;
		final int numOfpermits = 1;
		
		Semaphore sem = new Semaphore(numOfpermits, true);
		ThreadB threads[] = new ThreadB[numOfThreads];
		
		for(int i = 0; i < numOfThreads; i++)
		{
			threads[i] = new ThreadB(sem, "Tread" + i);
			threads[i].start();
		}
	}

}
class ThreadB extends Thread{
	String threadName;
	Semaphore sema;
	
	public ThreadB(Semaphore semaphore, String name)
	{
		this.threadName = name;
		this.sema = semaphore;
	}
	
	@Override
	public void run() {
		try {
			sema.acquire();
			System.out.println(threadName + " 세마포 획득 ...");
			System.out.println(threadName + " 작업중 ...");
			Thread.sleep(1000);
			System.out.println(threadName + " 작업 종료 ...");
			System.out.println(threadName + " 세마포 양도 ...");
			sema.release();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}