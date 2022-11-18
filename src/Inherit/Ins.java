package Inherit;

//フィールドの前につけるthisの有無について
public class Ins {
	public String color;
	public String price;

	Ins() {
	}
	
	//フィールドと引数が同じ名称ならthisは必要
	public void setColor(String color){
		this.color = color;
	}
	
	//合ってもよい
	public String getColor() {
		return this.color;
	}
	
	//引数と違う名称ならthisは無くてもいい（有る方が分かりやすいが）
	public void setPrice(String pri){
		price = pri;
	}
	
	//返すだけなら別に不要（合ってもいいが）
	public String getPrice() {
		return price;
	}

}
