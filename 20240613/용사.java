package 용사키우기;

import java.util.Scanner;

public class 용사 extends 사람 implements 상태이상, 감정표현{

	용사(){
		
	}
	
	용사(String name){
		this.name = name;
		Initialize();
	}
	
	public void Initialize()
	{
		status = new 상태창();
		inventory = new 소지품();
	}

	public void 아이템획득(아이템 item)
	{
		inventory.아이템획득(item);
	}
	
	public void 인벤토리보기()
	{
		inventory.showItem();
	}
	
	void 아이템발견()
	{
		아이템 item = 시스템.랜덤아이템생성() ;
		item.아이템정보보이기();
		
		System.out.println("선택해주세요 ( 1. 획득 , 2. 포기 ) : ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		if ( choice == 1) 아이템획득(item);
		else 
		{
			System.out.println("아이템을 포기했다.");
			inventory.showItem();
		}
		
	}
	
	public void 몬스터발견() {
		// TODO Auto-generated method stub
		몬스터 mon = new 몬스터();
		mon.랜덤몬스터생성();
		
		System.out.println("몬스터를 발견했다!!!!");
		mon.상태창보기();
		
		System.out.println("선택해주세요 ( 1. 싸운다 , 2. 도망간다 ) : ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		if ( choice == 1) {
			System.out.println("싸움을 시작합니다.");
			
			
		}
		else 
		{
			System.out.println("싸움을 포기했다.");
		}
	}
	
	
	
	
	
	
	
	


	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void 독상태가됨() {
		// TODO Auto-generated method stub
		System.out.println("독에 당했다!!!");
	}
	
	@Override
	public void 기쁨() {
		// TODO Auto-generated method stub
		System.out.println("기쁘다");
	}

	@Override
	public void 놀람() {
		// TODO Auto-generated method stub
		System.out.println("!!! 놀랐다 !!!");
	}

	@Override
	public void 황당함() {
		// TODO Auto-generated method stub
		System.out.println("??? 황당하다 ???");
	}
}