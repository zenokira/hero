package src;

import java.util.Scanner;

public class ThreadExample implements Runnable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("주 스레드 시작합니다");
		
		Thread t1 = new Thread(new ThreadExample());
		t1.start();
		
		System.out.println("자식 스레드 시작합니다");
		
		System.out.println("주 스레드 기다립니다");
		
		t1.join();
		System.out.println("주 스레드 다시 시작합니다");
	}

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("정수 입력을 기다리고 있습니다. 입력 바랍니다. >>");
		Scanner sc = new Scanner(System.in);
		
		int val = sc.nextInt();
		
		System.out.println("자식 스레드 종료합니다.");
	}
}
