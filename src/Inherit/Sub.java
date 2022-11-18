package Inherit;

public class Sub extends Sup {
	Sub(Integer i){
		super(i);
	}
	
	int getAmmount(Integer num){
		int i = super.getAmmount(num);
		this.ammount =  this.num * 100 - (i * 1/5);
		return this.ammount;
	}

}
