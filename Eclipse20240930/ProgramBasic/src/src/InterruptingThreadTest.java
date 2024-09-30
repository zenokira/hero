package src;

public class InterruptingThreadTest extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread pro = new Pro();
		Thread con = new Consum();
		
		pro.setPriority(Thread.MIN_PRIORITY);
		con.setPriority(Thread.MAX_PRIORITY);
		
		pro.start();
		con.start();
	}

}



class Pro extends Thread
{
	public void run()
	{
		for(int i = 0; i < 5; i++)
		{
			System.out.println("pro : " + i);
			//Thread.yield();
		}
	}
}

class Consum extends Thread
{
	public void run()
	{
		for(int i = 0; i < 5; i++)
		{
			System.out.println("con : " + i);
			//Thread.yield();
		}
	}
}
