package Inherit;

public class Sup {

	int num;
	int ammount;

	Sup(Integer i) {
		this.num = i;
	}

	int getAmmount(Integer num) {
		this.ammount = this.num * 100;
		return this.ammount;
	}

}
