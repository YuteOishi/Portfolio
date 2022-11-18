package Inherit;

public class Main {

	public static void main(String[] args) {
		Sup sup = new Sup(33);
		Sub sub = new Sub(45);
		
		System.out.println(sup.getAmmount(sup.num));
		System.out.println(sub.getAmmount(sub.num));
		
		Ins ins = new Ins();
		ins.setColor("黒");
		System.out.println(ins.getColor());
		
		ins.setPrice("100円");
		System.out.println(ins.getPrice());
		
		char c = 'b';
		System.out.println((byte)c);
		
	}
	
	public static void bar() {
    	System.out.println("----------------------------------------------");
    }
}
