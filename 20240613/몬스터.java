package 용사키우기;

public class 몬스터 extends 상태창 implements 상태이상 {
	private String name;
	private String [] strMonsterlist = { "토끼", "여우", "슬라임", "고블린", "오크" };
	private final int MonsterIdx = 5;

	몬스터() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void 랜덤몬스터생성() {

		int rT = 몬스터종류생성(getMonsterIdx());
		int rLV = 몬스터LV생성(rT + 1);
		int rHP = 몬스터HP생성(rLV);
		int rMP = 몬스터MP생성(rLV);

		setName(getStrMonsterlist()[rT]);
		setLV(rLV);
		initHP(rHP);
		initMP(rMP);
		
		set몬스터공격력(rLV);
		set몬스터방어력(rLV);
	}

	
	public String[] getStrMonsterlist() {
		return strMonsterlist;
	}

	public void set몬스터공격력(int n)
	{
		int ad = 시스템.getRandInt(n) + n;
		set물리공격력(ad);
		int ap = 시스템.getRandInt(n) + n;
		set마법공격력(ap);
	}
	
	public void set몬스터방어력(int n)
	{
		int ac = 시스템.getRandInt(n) + n;
		set물리방어력(ac);
		int mr = 시스템.getRandInt(n) + n;
		set마법공격력(mr);
	}

	public int getMonsterIdx() {
		return MonsterIdx;
	}

	int 몬스터종류생성(int n) {
		return 시스템.getRandInt(n);
	}

	int 몬스터LV생성(int n) {
		return 시스템.getRandInt(n) + n;
	}

	int 몬스터HP생성(int n) {
		return 시스템.getRandInt(n) * 10 + n * 30;
	}

	int 몬스터MP생성(int n) {
		return 시스템.getRandInt(n) * 10 + n * 30 - 15;
	}

	@Override
	public void 독상태가됨() {
		System.out.println();
	}

	@Override
	public void 상태창보기() {
		System.out.println();
		System.out.printf("%s(%d)\t", getName(), getLV());
		System.out.println("HP : " + getHP() + " / " + getMaxHP());
	}

}
