package PracticeEnum;

public class Main {

	public static void main(String[] args) {
		
		System.out.println(Member.Cherry.ordinal());
		System.out.println(Member.valueOf("Cherry"));
		System.out.println(Member.Cherry);
		System.out.println(Member.Cherry.japanese);
		System.out.println(Member.Cherry.getJapanese());

		Inherit.Main.bar();
		
		Member Orange = Member.Orange;
		Member Wan = Member.Orange;
		System.out.println(Orange.ordinal());
		System.out.println(Orange);
		System.out.println(Orange.japanese);
		System.out.println(Wan.getJapanese());
		
		Inherit.Main.bar();
		
		Member Apple = Member.valueOf("Apple");
		System.out.println(Apple.getJapanese());
		
		Inherit.Main.bar();
		
		for (Member member : Member.values()) {
			System.out.println(member.name());
		}
		
		Inherit.Main.bar();
		
		for (Member member : Member.values()) {
			System.out.println(member +  "は日本語で" + member.japanese 
					+ "で、値段は"+member.price+"です。");
		}
		
		Inherit.Main.bar();
		
		for (Member member : Member.values()) {
			member.describe();
			
		}
	}

}
