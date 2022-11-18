package PracticeEnum;

public enum Member{
	//ここでもうインスタンス生成してる感じ
	//Orangeインスタンスは引数オレンジのため、コンストラクタ13行目の実行でOrange.japanese=オレンジとなる
	Orange("オレンジ","50円"), 
	Apple("りんご","150円"), 
	Cherry("さくらんぼ","20円");

	public String japanese;
	public String price;
	
	Member(String japanese, String price) {
	    this.japanese = japanese;
	    this.price = price;
	  }
	
	//enum内メソッドなので、Orange.getJapanese()、Orange.describe()のように使う
	public String getJapanese() {
	    return this.japanese;
	  }
	
	public void describe() {
	    System.out.println("(呼出し版)"+this +  "は日本語で" + this.japanese 
				+ "で、値段は"+this.price+"です。");
	  }

}; 
